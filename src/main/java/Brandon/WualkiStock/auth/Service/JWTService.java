package Brandon.WualkiStock.auth.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private static final String SECRET_KEY = "5864592845985861465168134961635425629858985415187498465193246164697";

    public String getToken(UserDetails userDetails){
        Map<String, Object> extraClaim = new HashMap<>();
        extraClaim.put("role", userDetails.getAuthorities().toString());
        return getToken(extraClaim, userDetails);
    }

    private String getToken(Map<String, Object> extraClaim, UserDetails userDetails){
        return Jwts
            .builder()
            .claim("authorities", extraClaim.get("role"))
            .setClaims(extraClaim)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24)) //1 dia
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();    
    }
    
    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);//el subject va a estar alojado en el username
    }
    
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims (String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Date getExpiration(String token){
        return getClaim(token, Claims:: getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}
