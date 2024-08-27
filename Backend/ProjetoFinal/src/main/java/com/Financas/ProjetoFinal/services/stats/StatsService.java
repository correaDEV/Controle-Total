package com.Financas.ProjetoFinal.services.stats;


import com.Financas.ProjetoFinal.dto.GraphDTO;
import com.Financas.ProjetoFinal.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChatData();

    StatsDTO getStats();
}
