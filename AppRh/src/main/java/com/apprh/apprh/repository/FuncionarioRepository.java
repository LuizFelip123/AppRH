package com.apprh.apprh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apprh.apprh.models.Funcionario;
import java.util.List;


public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long>{
    
    public List<Funcionario> findByNome(String nome);

    @Query(value = "select * from funcionarios f where f.nome  like %?1%",nativeQuery = true)
     List<Funcionario> findByNomes(String nome);
    
}
