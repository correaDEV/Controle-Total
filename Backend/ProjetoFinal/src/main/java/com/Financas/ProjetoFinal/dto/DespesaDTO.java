package com.Financas.ProjetoFinal.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class DespesaDTO {

    private Long id;


    private String title;


    private String description;


    private String category;


    private LocalDate date;


    private Integer amount;

}
