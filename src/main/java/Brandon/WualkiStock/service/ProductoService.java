package Brandon.WualkiStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Brandon.WualkiStock.models.dto.ProductoDto;
import Brandon.WualkiStock.models.dto.ProductoRequest;
import Brandon.WualkiStock.models.entity.Producto;
import Brandon.WualkiStock.repository.ProductoRepo;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepo productoRepo;

    public void addProduc(ProductoRequest productoRequest){
        Producto producto = Producto.builder()
            .nombre(productoRequest.getNombre())
            .stock(productoRequest.getStock())
            .precioLista(productoRequest.getPrecioLista())
            .invercion(productoRequest.getInvercion())
            .build();
        productoRepo.save(producto);
    }
    
    public List<ProductoDto> getAllProductos(){
        List<Producto> productos = productoRepo.findAll();
        return productos.stream().map(this::mapProductoDto).toList();  
    }

    public Optional<Producto> listarID(Long id){
        return productoRepo.findById(id);
    }

    public ProductoDto mapProductoDto(Producto producto){
        return ProductoDto.builder()
            .id(producto.getId())
            .nombre(producto.getNombre())
            .stock(producto.getStock())
            .invercion(producto.getInvercion())
            .precioLista(producto.getPrecioLista())
            .build();
    }
    
    public Producto modifProducto(Long id, Producto producto){
        Producto productoencontrado = productoRepo.findById(id).orElse(null);
        if (productoencontrado != null) {
            productoencontrado.setNombre(producto.getNombre());
            productoencontrado.setStock(producto.getStock());
            productoencontrado.setInvercion(producto.getInvercion());
            productoencontrado.setPrecioLista(producto.getPrecioLista());
        }
        return this.productoRepo.save(productoencontrado);
    }
    public void  save(Producto producto){
        productoRepo.save(producto);
    }
    
    public void eliminarProducto(Long id){
        this.productoRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return productoRepo.existsById(id);
    }
    public Optional<Producto> getByNombre(String nombre){
        return productoRepo.findByNombre(nombre);
    }

    public boolean existsByNombre(String nombre){
        return productoRepo.existsByNombre(nombre);
    }
}
