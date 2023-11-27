package Brandon.WualkiStock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Brandon.WualkiStock.models.dto.ProductoDto;
import Brandon.WualkiStock.models.dto.ProductoRequest;
import Brandon.WualkiStock.models.dto.UsuarioRequest;
import Brandon.WualkiStock.models.entity.Producto;
import Brandon.WualkiStock.models.entity.Usuario;
import lombok.RequiredArgsConstructor;
import Brandon.WualkiStock.service.ProductoService;
import Brandon.WualkiStock.service.UsuarioService;

@RequiredArgsConstructor
@RestController // para poder manejar solicitudes HTTP 
@RequestMapping("/api/v1")
@CrossOrigin (origins = "http://localhost:4200") //conexion con el frontend
public class wualkiController {

    //Crear el Usuario
    private final UsuarioService usuarioService;
    private final ProductoService productoService;
    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UsuarioRequest usuarioRequest){
        this.usuarioService.addNewUser(usuarioRequest);
    }
    //login del usuario
    @PostMapping("/User")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> login(@RequestBody UsuarioRequest usuarioRequest){
    return ResponseEntity.ok(usuarioService.login(usuarioRequest.getUsername(), usuarioRequest.getPassword()));
    }

    //Agregar un nuevo producto
    @PostMapping("/addProduc")
    @ResponseStatus(HttpStatus.CREATED)
    public void nuevoProducto(@RequestBody ProductoRequest productoRequest){
        this.productoService.addNewProduc(productoRequest);
    }

    @GetMapping("/allProduct")
    public List<ProductoDto> getAllProductos(){
        return this.productoService.getAllProductos();
    }
    @PostMapping("/editProducto/{id}")
    public void editProduc(@PathVariable int id, Producto producto){
 
    }
}
