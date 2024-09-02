package com.apprh.apprh.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Candidato")
@Table(name="candidatos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Candidato {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 
  @Column(unique = true)
  private String rg;
  @NotBlank(message = "O nome é um campo obrigatório")
  private String nome;
  @Column(unique = true)
  @NotBlank(message = "O email é um campo obrigatório")
  private String email;

  @ManyToOne
  private Vaga vaga;
}
