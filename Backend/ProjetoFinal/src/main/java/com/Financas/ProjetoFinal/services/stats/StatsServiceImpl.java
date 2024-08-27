package com.Financas.ProjetoFinal.services.stats;

import com.Financas.ProjetoFinal.dto.GraphDTO;
import com.Financas.ProjetoFinal.dto.StatsDTO;
import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.entity.Renda;
import com.Financas.ProjetoFinal.repository.DespesaRepository;
import com.Financas.ProjetoFinal.repository.RendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final RendaRepository rendaRepository;
    private final DespesaRepository despesaRepository;

    public GraphDTO getChatData() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setDespesaList(despesaRepository.findByDateBetween(startDate, endDate));
        graphDTO.setRendaList(rendaRepository.findByDateBetween(startDate, endDate));

        return graphDTO;
    }

    public StatsDTO getStats() {
        // Obter a soma total de rendas e despesas
        Double totalRenda = rendaRepository.sumAllAmounts();
        Double totalDespesa = despesaRepository.sumAllAmounts();

        // Obter o último objeto Renda e Despesa
        Optional<Renda> rendaRecente = rendaRepository.findFirstByOrderByDateDesc();
        Optional<Despesa> despesaRecente = despesaRepository.findFirstByOrderByDateDesc();

        // Criar e configurar o objeto StatsDTO
        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setDespesa(totalDespesa);
        statsDTO.setRenda(totalRenda);

        // Configurar o último objeto de renda e despesa, se presente
        rendaRecente.ifPresent(statsDTO::setRendarecente);
        despesaRecente.ifPresent(statsDTO::setDespesarecente);

        statsDTO.setEquilibrio(totalRenda-totalDespesa);

        List<Renda> rendaList = rendaRepository.findAll();
        List<Despesa> despesaList = despesaRepository.findAll();

        OptionalDouble rendaminima = rendaList.stream().mapToDouble(Renda::getAmount).min();
        OptionalDouble rendamaxima = rendaList.stream().mapToDouble(Renda::getAmount).max();


        OptionalDouble despesaminima = despesaList.stream().mapToDouble(Despesa::getAmount).min();
        OptionalDouble despesamaxima = despesaList.stream().mapToDouble(Despesa::getAmount).max();

        statsDTO.setDespesaminmaxima(despesamaxima.isPresent() ? despesamaxima.getAsDouble() : null);
        statsDTO.setDespesaminima(despesaminima.isPresent() ? despesaminima.getAsDouble() : null);

        statsDTO.setRendamaxima(rendamaxima.isPresent() ? rendamaxima.getAsDouble() : null);
        statsDTO.setRendaminima(rendaminima.isPresent() ? rendaminima.getAsDouble() : null);


        return statsDTO;
    }
}
