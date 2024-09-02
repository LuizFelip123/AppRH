package com.apprh.apprh.models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Vaga")
@Table(name="vagas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Vaga {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; 

   @NotBlank(message = "O nome é campo obrigatório")
   private String nome;
   
   @NotBlank(message = "A descrição é um campo obrigatório")
   private String descricao;
   
   @NotBlank(message = "A data é um campo obrigatório")
   private String data;

   @NotBlank(message = "O salário é um campo obrigatório")
   private String salario;
   @OneToMany(mappedBy="vaga", cascade = CascadeType.REMOVE)
   private List<Candidato> candidatos;

   
}
