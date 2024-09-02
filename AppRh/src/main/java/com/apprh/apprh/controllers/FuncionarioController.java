package com.apprh.apprh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apprh.apprh.models.Dependente;
import com.apprh.apprh.models.Funcionario;
import com.apprh.apprh.repository.DependenteRepository;
import com.apprh.apprh.repository.FuncionarioRepository;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DependenteRepository dependenteRepository;
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("funcionarios",funcionarioRepository.findAll());
        return "funcionario/listaFuncionario";
    }

    @GetMapping("/adicionar")
    public String form(Funcionario funcionario){
        
        return "funcionario/formFuncionario";
    }
    @PostMapping("/adicionar")
    public String addForm(@Valid Funcionario funcionario, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/funcionario/adicionar";
        }
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/{id}")
    public String formDep(@PathVariable Long id, Dependente dependente, Model model){
        model.addAttribute("funcionario", funcionarioRepository.findById(id).get() );
        return "funcionario/dependentes";
    }

    @PostMapping("/{id}")
    public String postMethodName(@PathVariable Long id,@Valid Dependente dependente, BindingResult result, RedirectAttributes redirectAttributes) {
        //TODO: process POST request
        if( result.hasErrors()){
       
            return "redirect:/funcionario/{id}";
        }
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        dependente.setFuncionario(funcionario);;
        dependente.setId(null);
        dependenteRepository.save(dependente);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/funcionario/{id}";
    }
    @GetMapping("/{id}/candidato/{idDependente}")
    public String deleteDependente(@PathVariable Long id, @PathVariable Long idDependente  ){
        dependenteRepository.deleteById(idDependente);
        return "redirect:/funcionario/{id}";
    }

}
