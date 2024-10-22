package com.Financas.ProjetoFinal.controller;

import com.Financas.ProjetoFinal.dto.RendaDTO;
import com.Financas.ProjetoFinal.entity.Renda;
import com.Financas.ProjetoFinal.services.Renda.RendaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/renda")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RendaController {

    private final RendaService rendaService;

    // Requer autenticação para criar uma nova renda
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<?> postRenda(@RequestBody RendaDTO rendaDTO) {
        Renda createdRenda = rendaService.postRenda(rendaDTO);
        if (createdRenda != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRenda);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Requer autenticação para listar todas as rendas
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<?> getAllRendas() {
        return ResponseEntity.ok(rendaService.getAllRendas());
    }

    // Requer autenticação para atualizar uma renda
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRenda(@PathVariable Long id, @RequestBody RendaDTO rendaDTO) {
        try {
            return ResponseEntity.ok(rendaService.updateRenda(id, rendaDTO));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado");
        }
    }

    // Requer autenticação para buscar uma renda pelo ID
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getRendaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(rendaService.getRendaById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado");
        }
    }

    // Requer autenticação para deletar uma renda
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRenda(@PathVariable Long id) {
        try {
            rendaService.deleteRenda(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado");
        }
    }
}
