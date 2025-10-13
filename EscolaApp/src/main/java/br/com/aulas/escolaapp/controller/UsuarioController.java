package br.com.aulas.escolaapp.controller;


import br.com.aulas.escolaapp.model.Usuario;
import br.com.aulas.escolaapp.repository.UsuarioRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepo repo;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        if (usuario.getRole() == null || usuario.getRole().isEmpty()) {
            usuario.setRole(Set.of("USER"));
        }
        Usuario salvo = repo.save(usuario);
        salvo.setPassword(null); // não retornar senha
        return ResponseEntity.status(201).body(salvo);
    }
}
