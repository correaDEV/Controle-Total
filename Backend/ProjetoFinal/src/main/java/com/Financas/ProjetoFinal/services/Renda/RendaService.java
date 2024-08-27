package com.Financas.ProjetoFinal.services.Renda;


import com.Financas.ProjetoFinal.dto.RendaDTO;
import com.Financas.ProjetoFinal.entity.Renda;

import java.util.List;

public interface RendaService {

    Renda postRenda(RendaDTO rendaDTO);

    List<RendaDTO> getAllRendas();

    Renda updateRenda(Long id, RendaDTO rendaDTO);

    RendaDTO getRendaById(Long id);

    void deleteRenda(Long id);



}
