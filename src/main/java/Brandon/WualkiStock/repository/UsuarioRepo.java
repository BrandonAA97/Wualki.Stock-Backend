package Brandon.WualkiStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Brandon.WualkiStock.models.entity.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByUsername(String username);

    boolean existsByPassword(String password);

    boolean existsByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String password);

}
