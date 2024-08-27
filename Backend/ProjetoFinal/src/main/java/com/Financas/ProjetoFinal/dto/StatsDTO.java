package com.Financas.ProjetoFinal.dto;


import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.entity.Renda;
import lombok.Data;

@Data
public class StatsDTO {

    private Double renda;

    private Double despesa;

    private Renda rendarecente;

    private Despesa despesarecente;

    private Double  equilibrio;

    private Double  rendaminima;

    private Double  rendamaxima;

    private Double  despesaminima;

    private Double  despesaminmaxima;


}
