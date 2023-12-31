package Brandon.WualkiStock.auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Brandon.WualkiStock.auth.User.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

   
}

