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

import com.apprh.apprh.models.Candidato;
import com.apprh.apprh.models.Vaga;
import com.apprh.apprh.repository.CandidatoRepository;
import com.apprh.apprh.repository.VagaRepository;

import jakarta.validation.Valid;


@RequestMapping("/vaga")
@Controller
public class VagaController {
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
   
    @GetMapping("/cadastrar")
    public String form(Vaga vaga){
        return "vaga/formVaga";
    }

    @PostMapping("/cadastrar")
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/vaga/cadastrar";
        }
            
        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redirect:/vaga/listar"; 
    }
    @GetMapping("/listar")
    public String list(Model model){
        model.addAttribute("vagas", vagaRepository.findAll());
        return "vaga/listaVaga";
    }

    @GetMapping("/{id}")
    public String detalhesVagas(@PathVariable Long id, Model model, Candidato Candidato){
        model.addAttribute("vaga", vagaRepository.findById(id).get());
        return "vaga/detalhesVaga";
    }
    @GetMapping("/delete/{id}")
    public String deleteVaga(@PathVariable Long id ){
        vagaRepository.deleteById(id);
        return "redirect:/vaga/listar";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model ){
         model.addAttribute("vaga",vagaRepository.findById(id).get());
         return "vaga/update-vaga";   
    }
    @PostMapping("/editar/{id}")
    public String updateVaga( @PathVariable Long id,  @Valid Vaga vaga, BindingResult result){
        if(result.hasErrors()){
            vaga.setId(id);
            return "vaga/update-vaga"; 
        }
         vagaRepository.save(vaga);
        return "redirect:/vaga/listar";
    }

    @PostMapping("/{id}")
    public String addCandidato(@PathVariable Long id, @Valid Candidato candidato,  BindingResult result, RedirectAttributes redirectAttributes){
       if(result.hasErrors()){
        return "redirect:/";
        }
        Vaga vaga = vagaRepository.findById(id).get();
        candidato.setVaga(vaga);
        candidatoRepository.save(candidato);
        redirectAttributes.addAttribute("id", id);
        return"redirect:/vaga/{id}";
    }
    @GetMapping("/{id}/candidato/{idCandidato}")
    public String deleteCandidato(@PathVariable Long id, @PathVariable Long idCandidato  ){
        candidatoRepository.deleteById(idCandidato);
        return "redirect:/vaga/{id}";
    }
}
