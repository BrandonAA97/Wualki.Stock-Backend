package Brandon.WualkiStock.models.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class productoResponse {
    String nombre;
    Long invercion;
    Long stock;
    Long precioLista;
}
