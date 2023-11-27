package Brandon.WualkiStock.service;

import java.util.List;

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
    public void addNewProduc(ProductoRequest productoRequest){
        Producto producto = Producto.builder()
            .nombre(productoRequest.getNombre())
            .stock(productoRequest.getStock())
            .invercion(productoRequest.getInvercion())
            .precioLista(productoRequest.getPrecioLista())
            .build();
        productoRepo.save(producto);
    }
    
   public List<ProductoDto> getAllProductos(){
        List<Producto> productos = productoRepo.findAll();
        return productos.stream().map(this::mapProductoDto).toList();   
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
}
