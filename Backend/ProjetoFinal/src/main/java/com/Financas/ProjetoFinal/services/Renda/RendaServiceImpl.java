package com.Financas.ProjetoFinal.services.Renda;


import com.Financas.ProjetoFinal.dto.RendaDTO;
import com.Financas.ProjetoFinal.entity.Renda;
import com.Financas.ProjetoFinal.repository.RendaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RendaServiceImpl implements RendaService {

    private final RendaRepository renpaRepository;

    public Renda postRenda(RendaDTO rendaDTO) {
        return saveOrUpdateRenda(new Renda(), rendaDTO);

    }

    private Renda saveOrUpdateRenda(Renda renda, RendaDTO rendaDTO) {
        renda.setTitle(rendaDTO.getTitle());
        renda.setDate(rendaDTO.getDate());
        renda.setAmount(rendaDTO.getAmount());
        renda.setCategory(rendaDTO.getCategory());
        renda.setDescription(rendaDTO.getDescription());

        return renpaRepository.save(renda);
    }

    public Renda updateRenda(Long id, RendaDTO rendaDTO) {
        Optional<Renda> optionalRenda = renpaRepository.findById(id);
        if (optionalRenda.isPresent()) {
            return saveOrUpdateRenda(optionalRenda.get(), rendaDTO);
        }else {
            throw new EntityNotFoundException("Renda não está presente com id " + id);
        }
    }


    public List<RendaDTO> getAllRendas() {
        return renpaRepository.findAll().stream()
                .sorted(Comparator.comparing(Renda::getDate).reversed())
                .map(Renda::getRendaDTO)
                .collect(Collectors.toList());

    }
    public RendaDTO getRendaById(Long id) {
        Optional<Renda> optionalRenda = renpaRepository.findById(id);
        if (optionalRenda.isPresent()) {
            return optionalRenda.get().getRendaDTO();
        }else {
            throw new EntityNotFoundException("Renda não está presente com id " + id);
        }
    }

     public void deleteRenda(Long id) {
        Optional<Renda> optionalRenda = renpaRepository.findById(id);
        if (optionalRenda.isPresent()) {
            renpaRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("Renda não está presente com id " + id);
        }
     }
}
