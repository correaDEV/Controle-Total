package com.Financas.ProjetoFinal.controller;

import com.Financas.ProjetoFinal.entity.User;
import com.Financas.ProjetoFinal.repository.UserRepository;
import jakarta.validation.Valid;  // Verifique o import correto
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        // Criptografa a senha antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Define a role padrão, se não fornecida
        if(user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        userRepository.save(user);
        return ResponseEntity.ok("Usuário registrado com sucesso");
    }
}
