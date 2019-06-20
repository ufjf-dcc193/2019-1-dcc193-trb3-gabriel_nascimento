package br.dcc.trab3.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.model.Etiqueta;

/**
 * EtiquetaController
 */
@Controller
@RequestMapping("/etiqueta/")
public class EtiquetaController {

    @Autowired
    EtiquetaRepository etiquetas;

    @RequestMapping("")
    public String homeEtiqueta(Model model){
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        return "etiqueta/etiqueta-index";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("etiqueta", new Etiqueta());
        return "etiqueta/etiqueta-form";
    }

    @PostMapping("/salvar")
    public ModelAndView salvarEtiqueta(@Valid Etiqueta etiqueta, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("etiqueta/etiqueta-form");
            mv.addObject("etiqueta", etiqueta);
            return mv;
        }
        etiquetas.save(etiqueta);
        mv.setViewName("redirect:/etiqueta/");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String preEditarEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("etiqueta", etiquetas.findById(id).get());
        return "etiqueta/etiqueta-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarSalvarEtiqueta(@Valid Etiqueta etiqueta, @PathVariable Long id, BindingResult binding){
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
           mv.setViewName("etiqueta/etiqueta-edit");
           mv.addObject("etiqueta", etiqueta);
           return mv;
       }
       mv.setViewName("redirect:/etiqueta/");
       etiquetas.save(etiqueta);
       return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletarEtiqueta(@PathVariable Long id){
        etiquetas.deleteById(id);
        return "redirect:/etiqueta/";
    }
}