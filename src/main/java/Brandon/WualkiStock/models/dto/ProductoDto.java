package Brandon.WualkiStock.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDto {
    private Long id;
    private String nombre;
    private Long cantidad;
    private Long precio;

}
