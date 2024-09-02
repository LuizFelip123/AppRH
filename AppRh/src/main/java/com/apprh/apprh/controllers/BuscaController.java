package com.apprh.apprh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apprh.apprh.repository.CandidatoRepository;
import com.apprh.apprh.repository.DependenteRepository;
import com.apprh.apprh.repository.FuncionarioRepository;
import com.apprh.apprh.repository.VagaRepository;


@Controller
@RequestMapping
public class BuscaController {
    @Autowired
    private DependenteRepository dependenteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/")
    public String buscarIndex(@RequestParam("buscar") String busca, @RequestParam("nome") String nome, Model model){
   
        if(nome.equals("nomefuncionario")){
            System.out.println("CAIU AQUI ! \n");
            model.addAttribute("funcionarios", funcionarioRepository.findByNomes(busca));
        }else if(nome.equals("nomedependente")){
            model.addAttribute("dependentes", dependenteRepository.findByNomeDependentes(busca));
        }else if(nome.equals("nomecandidato")){         
            model.addAttribute("candidatos", candidatoRepository.findByNomes(busca));
        }else if(nome.equals("titulovaga")){
            model.addAttribute("vagas",vagaRepository.findByNomes(busca));
        }else{
            model.addAttribute("funcionarios", funcionarioRepository.findByNomes(busca));
            model.addAttribute("dependentes", dependenteRepository.findByNomeDependentes(busca));
            model.addAttribute("candidatos", dependenteRepository.findByNomeDependentes(busca));
            model.addAttribute("vagas",vagaRepository.findByNomes(busca));

        }
        return "index";
    }
}
