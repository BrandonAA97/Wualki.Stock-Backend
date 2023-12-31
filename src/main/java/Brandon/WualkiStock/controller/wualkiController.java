package Brandon.WualkiStock.controller;

import java.util.List;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Brandon.WualkiStock.models.dto.Mensaje;
import Brandon.WualkiStock.models.dto.ProductoDto;
import Brandon.WualkiStock.models.dto.ProductoRequest;
import Brandon.WualkiStock.models.entity.Producto;
import Brandon.WualkiStock.service.ProductoService;




@RequiredArgsConstructor
@RestController // para poder manejar solicitudes HTTP 
@RequestMapping("/api/v1")
@CrossOrigin (origins = "http://localhost:4200") //conexion con el frontend
public class wualkiController {

    @Autowired
    private final ProductoService productoService;

//Agregar un nuevo producto
    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void nuevoProducto(@RequestBody ProductoRequest productoRequest){
        this.productoService.addProduc(productoRequest);
    }
//listar todos los productos
    @GetMapping("/allProduct")
    public List<ProductoDto> getAllProductos(){
        return this.productoService.getAllProductos();
    }
//obtener un producto por id
    @GetMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Producto> editProduc(@PathVariable Long id){
        Producto prod = productoService.listarID(id).get();
        return new ResponseEntity<>(prod, HttpStatus.OK); 
    }
//editar los productos por id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody ProductoDto productoDto){
        if(!productoService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if(productoDto.getPrecioLista()==null || productoDto.getPrecioLista()<0 )
            return new ResponseEntity<>(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.listarID(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setStock(productoDto.getStock());
        producto.setPrecioLista(productoDto.getPrecioLista());
        producto.setInvercion(productoDto.getInvercion());
        productoService.save(producto);
        return new ResponseEntity<>(new Mensaje("producto actualizado"), HttpStatus.OK);
    }
//eliminar un producto
    @DeleteMapping("/deleteProd/{id}")
    @ResponseStatus(HttpStatus.OK)
     public ResponseEntity<?> delete(@PathVariable Long id){
        if(!productoService.existsById(id))
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(new Mensaje(" Producto eliminado"), HttpStatus.OK);
    }   
}
