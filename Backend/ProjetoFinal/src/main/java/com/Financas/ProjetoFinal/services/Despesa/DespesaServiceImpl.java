package com.Financas.ProjetoFinal.services.Despesa;

import com.Financas.ProjetoFinal.dto.DespesaDTO;
import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.repository.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaRepository despesaRepository;


    public Despesa postDespesa(DespesaDTO despesaDTO) {
        return saveOrUpdateDespesa(new Despesa(), despesaDTO);
    }

    private Despesa saveOrUpdateDespesa(Despesa despesa, DespesaDTO despesaDTO) {
        despesa.setTitle(despesaDTO.getTitle());
        despesa.setDate(despesaDTO.getDate());
        despesa.setAmount(despesaDTO.getAmount());
        despesa.setCategory(despesaDTO.getCategory());
        despesa.setDescription(despesaDTO.getDescription());

        return despesaRepository.save(despesa);
    }

    public Despesa updateDespesa(Long id, DespesaDTO despesaDTO) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
        if(optionalDespesa.isPresent()) {
            return saveOrUpdateDespesa(optionalDespesa.get(), despesaDTO);
        }else {
            throw new EntityNotFoundException(("Despesa não encontrada com esse id" + id));
        }
    }

    public List<Despesa> getAllDespesas() {
        return despesaRepository.findAll().stream()
                .sorted(Comparator.comparing(Despesa::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Despesa getDespesaById(Long id) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
        if (optionalDespesa.isPresent()) {
            return optionalDespesa.get();
        } else{
            throw new EntityNotFoundException("Despesa não esta presente com id " + id);

        }
    }
    public void deleteDespesa(Long id) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
        if (optionalDespesa.isPresent()) {
            despesaRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Despesa não esta presente com id " + id);

        }
    }


    }

