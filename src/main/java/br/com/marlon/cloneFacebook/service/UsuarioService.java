package br.com.marlon.cloneFacebook.service;

import br.com.marlon.cloneFacebook.models.UsuarioLogin;
import br.com.marlon.cloneFacebook.models.UsuarioModel;
import br.com.marlon.cloneFacebook.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel registerUser (UsuarioModel user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String passwordEncoder = encoder.encode(user.getPassword());
        user.setPassword(passwordEncoder);

        return usuarioRepository.save(user);
    }

    public Optional<UsuarioLogin> loginUser(Optional<UsuarioLogin> userLogin){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<UsuarioModel> user = usuarioRepository.findByEmail(userLogin.get().getEmail());

        if (user.isPresent()){
            if (encoder.matches(userLogin.get().getPassword(), user.get().getPassword())){

                String auth = userLogin.get().getEmail() + ":" + userLogin.get().getPassword();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
                String authHeader = "Basic " + new String(encodeAuth);

                userLogin.get().setName(user.get().getName());
                userLogin.get().setLastName(user.get().getLastName());
                userLogin.get().setId(user.get().getId());
                userLogin.get().setToken(authHeader);
                userLogin.get().setPhoto(user.get().getPhoto());

                return userLogin;
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User or password invalid.", null);

        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not exists.", null);
    }
}
