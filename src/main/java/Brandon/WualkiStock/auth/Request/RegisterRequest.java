package Brandon.WualkiStock.auth.Request;

import java.util.List;

import Brandon.WualkiStock.auth.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    String username;
    String password;
    String email;
    List<Role> role;
}
