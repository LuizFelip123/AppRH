package com.apprh.apprh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apprh.apprh.models.Candidato;

import java.util.List;



public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    public Candidato findByRg(String rg);
    public List<Candidato> findByNome(String nome);

    @Query(value = "select * from candidatos c where c.nome  like %?1%",nativeQuery = true)
     List<Candidato> findByNomes(String nome);
}
