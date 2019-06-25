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

import br.dcc.trab3.demo.dao.AnotacaoRepository;
import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.dao.VinculoRepository;
import br.dcc.trab3.demo.model.Vinculo;

/**
 * VinculoController
 */
@Controller
@RequestMapping("/vinculo/")
public class VinculoController {

    @Autowired
    VinculoRepository vinculos;

    @Autowired
    AnotacaoRepository anotacoes;
    
    @Autowired
    EtiquetaRepository etiquetas;

    @Autowired
    ItemRepository itens;

    @RequestMapping("")
    public String homeVinculo(Model model){
        model.addAttribute("listVinculos", vinculos.findAll());
        return "vinculo/vinculo-index";
    }

    @RequestMapping("/criar")
    public String criarVinculo(Model model){
        model.addAttribute("vinculo", new Vinculo());
        model.addAttribute("listAnotacoes", anotacoes.findAll());
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        model.addAttribute("listItens", itens.findAll());
        return "vinculo/vinculo-form";
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarVinculo(@Valid Vinculo vinculo, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("vinculo/vinculo-form");
            mv.addObject("vinculo", vinculo);
            mv.addObject("listAnotacoes", anotacoes.findAll());
            mv.addObject("listEtiquetas", etiquetas.findAll());
            mv.addObject("listItens", itens.findAll());
            return mv;
        }
        vinculos.save(vinculo);
        mv.setViewName("redirect:/vinculo/");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String preEditarVinculo(@PathVariable Long id, Model model){
        model.addAttribute("vinculo", vinculos.findById(id).get());
        model.addAttribute("listAnotacoes", anotacoes.findAll());
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        model.addAttribute("listItens", itens.findAll());
        return "vinculo/vinculo-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarSalvarVinculo(@Valid Vinculo vinculo, @PathVariable Long id, BindingResult binding){
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
            mv.setViewName("vinculo/vinculo-form");
            mv.addObject("vinculo", vinculo);
            mv.addObject("listAnotacoes", anotacoes.findAll());
            mv.addObject("listEtiquetas", etiquetas.findAll());
            mv.addObject("listItens", itens.findAll());
            return mv;
       }
       mv.setViewName("redirect:/vinculo/");
       vinculos.save(vinculo);
       return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletarVinculo(@PathVariable Long id){
        vinculos.deleteById(id);
        return "redirect:/vinculo/";
    }
    
}