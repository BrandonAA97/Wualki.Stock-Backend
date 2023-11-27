package Brandon.WualkiStock.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto")
@Builder

public class Producto {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 45, nullable = false)
    private String nombre;

    @Column ( length = 10, nullable = false)
    private Long stock;

    @Column ( length = 10, nullable = false)
    private Long invercion;
   
    @Column ( length = 10, nullable = false)
    private Long precioLista;
}
