package Brandon.WualkiStock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Brandon.WualkiStock.models.entity.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long>{
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
