package com.apprh.apprh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apprh.apprh.models.Dependente;

import java.util.List;


public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    public List<Dependente> findByNome(String nome);

    @Query(value = "select * from dependentes d where d.nome like %?1%",nativeQuery = true)
     List<Dependente> findByNomeDependentes(String nome);
}
