package com.Financas.ProjetoFinal.repository;

import com.Financas.ProjetoFinal.entity.Despesa;
import com.Financas.ProjetoFinal.entity.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RendaRepository extends JpaRepository<Renda, Long> {

    List<Renda> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT sum(r.amount) FROM Renda r")
    Double sumAllAmounts();

    Optional<Renda> findFirstByOrderByDateDesc();
}
