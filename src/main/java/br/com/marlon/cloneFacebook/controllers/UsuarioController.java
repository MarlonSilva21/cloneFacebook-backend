package br.com.marlon.cloneFacebook.controllers;

import br.com.marlon.cloneFacebook.models.UsuarioLogin;
import br.com.marlon.cloneFacebook.models.UsuarioModel;
import br.com.marlon.cloneFacebook.repository.UsuarioRepository;
import br.com.marlon.cloneFacebook.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsers(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getUserById (@PathVariable long id){
        return usuarioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UsuarioModel>> getUserByName (@PathVariable String name){
        return ResponseEntity.ok(usuarioRepository.findByNameContainingIgnoreCase(name));
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioLogin> login (@RequestBody Optional<UsuarioLogin> user){
        return usuarioService.loginUser(user).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioModel> register(@RequestBody UsuarioModel user){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registerUser(user));
    }

    @PutMapping
    public ResponseEntity<UsuarioModel> editPost(@RequestBody UsuarioModel post){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(post));
    }

}
