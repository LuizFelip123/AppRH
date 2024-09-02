package com.apprh.apprh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apprh.apprh.models.Vaga;
import java.util.List;


public interface VagaRepository extends JpaRepository<Vaga, Long> {
    public List<Vaga> findByNome(String nome);

    @Query(value = "select * from vagas v where v.nome  like %?1%",nativeQuery = true)
     List<Vaga> findByNomes(String nome);
}
