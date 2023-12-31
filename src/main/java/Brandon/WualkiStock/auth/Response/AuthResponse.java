package Brandon.WualkiStock.auth.Response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse { //respuesta que devuelve el token, no importa si el registro o login
    String token;
    @Enumerated(EnumType.STRING)
    String role;
    String authorities;
    String username;
}
