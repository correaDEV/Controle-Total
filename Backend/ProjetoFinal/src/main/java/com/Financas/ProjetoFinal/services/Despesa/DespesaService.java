package com.Financas.ProjetoFinal.services.Despesa;

import com.Financas.ProjetoFinal.dto.DespesaDTO;
import com.Financas.ProjetoFinal.entity.Despesa;

import java.util.List;

public interface DespesaService {

    Despesa postDespesa(DespesaDTO despesaDTO);


    public List<Despesa> getAllDespesas();


    Despesa getDespesaById(Long id);


    Despesa updateDespesa(Long id, DespesaDTO despesaDTO);


    void deleteDespesa(Long id);

}
