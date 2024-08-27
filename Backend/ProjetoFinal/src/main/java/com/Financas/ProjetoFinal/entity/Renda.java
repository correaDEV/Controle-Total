package com.Financas.ProjetoFinal.entity;


import com.Financas.ProjetoFinal.dto.RendaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Renda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer amount;

    private LocalDate date;

    private String category;

    private String description;

    public RendaDTO getRendaDTO() {
        RendaDTO rendaDTO= new RendaDTO();

        rendaDTO.setId(id);
        rendaDTO.setTitle(title);
        rendaDTO.setAmount(amount);
        rendaDTO.setCategory(category);
        rendaDTO.setDescription(description);
        rendaDTO.setDate(date);

        return rendaDTO;
    }
}
