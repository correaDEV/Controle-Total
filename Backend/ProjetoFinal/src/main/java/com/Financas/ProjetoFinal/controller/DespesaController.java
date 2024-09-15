// src/main/java/com/Financas/ProjetoFinal/controller/DespesaController.java

package com.Financas.ProjetoFinal.controller;

import com.Financas.ProjetoFinal.dto.DespesaDTO;
import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.services.Despesa.DespesaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/despesa")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public ResponseEntity<?> postDespesa(@RequestBody DespesaDTO dto) {
        Despesa createdDespesa = despesaService.postDespesa(dto);
        if (createdDespesa != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDespesa);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDespesas() {
        return ResponseEntity.ok(despesaService.getAllDespesas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDespesaById(@PathVariable Long id) {
        try {
            Despesa despesa = despesaService.getDespesaById(id);
            return ResponseEntity.ok(despesa);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizacaoDespesa(@PathVariable Long id, @RequestBody DespesaDTO dto) {
        try {
            Despesa updatedDespesa = despesaService.updateDespesa(id, dto);
            System.out.println("Despesa atualizada: " + updatedDespesa);
            return ResponseEntity.ok(updatedDespesa);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDespesa(@PathVariable Long id) {
        try {
            despesaService.deleteDespesa(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado");
        }
    }
}
