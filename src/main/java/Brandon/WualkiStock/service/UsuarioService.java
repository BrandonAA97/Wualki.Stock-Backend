package Brandon.WualkiStock.service;

import java.util.List;
import java.util.Optional;

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
    public Usuario login(String string, String string2){
    Usuario user = usuarioRepo.findByUsernameAndPassword(string, string2);
    return user;
    }
}
