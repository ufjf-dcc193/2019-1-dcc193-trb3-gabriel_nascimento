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
import br.dcc.trab3.demo.model.Item;

/**
 * ItemController
 */
@Controller
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    ItemRepository itens;
    @Autowired
    AnotacaoRepository anotacoes;
    @Autowired
    EtiquetaRepository etiquetas;
    @Autowired
    VinculoRepository vinculos;

    @RequestMapping("")
    public String homeEtiqueta(Model model){
        model.addAttribute("listItens", itens.findAll());
        return "item/item-index";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("listAnotacoes", anotacoes.findAll());
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        model.addAttribute("listVinculos", vinculos.findAll());
        return "item/item-form";
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarEtiqueta(@Valid Item item, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("item/item-form");
            mv.addObject("item", item);
            return mv;
        }
        itens.save(item);
        mv.setViewName("redirect:/item/");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String preEditarEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("item", itens.findById(id).get());
        return "item/item-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarSalvarUsuario(@Valid Item item, @PathVariable Long id, BindingResult binding){
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
            mv.setViewName("item/item-form");
            mv.addObject("item", item);
            return mv;
       }
       mv.setViewName("redirect:/item/");
       itens.save(item);
       return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletarEtiqueta(@PathVariable Long id){
        itens.deleteById(id);
        return "redirect:/usuario/";
    }
    
}