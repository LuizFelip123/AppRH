package com.apprh.apprh.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Funcionario")
@Table(name="funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é um campo obrigatório")
    private String nome;
    @NotBlank(message = "A data de nascimento é campo obrigatório")
    private String dataNascimento;
    @NotBlank(message = "O email é um campo obrigatório")
    @Email
    private String email;
    @OneToMany(mappedBy="funcionario", cascade = CascadeType.REMOVE)
    private List<Dependente> dependentes;

}
