package com.Financas.ProjetoFinal.dto;


import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.entity.Renda;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Despesa> despesaList;

    private List<Renda> rendaList;


}
