package br.dcc.trab3.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.model.Etiqueta;
import br.dcc.trab3.demo.model.Usuario;

/**
 * EtiquetaController
 */
@Controller
@RequestMapping("/etiqueta/")
public class EtiquetaController {

    @Autowired
    EtiquetaRepository etiquetas;

    @Autowired
    ItemRepository itens;

    @RequestMapping("")
    public String homeEtiqueta(Model model, HttpSession session){
        if(session.getAttribute("ativo") == null){
            model.addAttribute("usuario", new Usuario());
            return "redirect:/";
        }
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

    @GetMapping("/gerenciar/{id}")
    public String gerenciarEtiqueta(@PathVariable Long id, Model model){
        Etiqueta aux = etiquetas.findById(id).get();
        model.addAttribute("titulo", aux.getTitulo());
        return "etiqueta/etiqueta-itens";
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