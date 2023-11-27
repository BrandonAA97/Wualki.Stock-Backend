package Brandon.WualkiStock.service;

import org.springframework.stereotype.Service;

import Brandon.WualkiStock.models.dto.UsuarioRequest;
import Brandon.WualkiStock.models.entity.Usuario;
import Brandon.WualkiStock.repository.UsuarioRepo;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepo usuarioRepo;
    public void addNewUser(UsuarioRequest usuarioRequest){
        Usuario user = Usuario.builder()
            .username(usuarioRequest.getUsername())
            .password(usuarioRequest.getPassword())
            .build();
        usuarioRepo.save(user);
    }
    public Usuario login(String username, String password){
    Usuario user = usuarioRepo.findByUsernameAndPassword(username, password);
    return user;
    }

}
