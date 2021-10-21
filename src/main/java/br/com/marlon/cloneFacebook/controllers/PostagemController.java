package br.com.marlon.cloneFacebook.controllers;

import br.com.marlon.cloneFacebook.models.PostagemModel;
import br.com.marlon.cloneFacebook.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<PostagemModel>> getAllPostagens(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagemModel> getPostagemById (@PathVariable long id){
        return postagemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostagemModel> createPost(@RequestBody PostagemModel post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(post));
    }

    @PutMapping
    public ResponseEntity<PostagemModel> editPost(@RequestBody PostagemModel post){
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(post));
    }

}
