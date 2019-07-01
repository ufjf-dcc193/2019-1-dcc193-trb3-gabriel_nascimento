package br.dcc.trab3.demo.controller;

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

import br.dcc.trab3.demo.dao.AnotacaoRepository;
import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.dao.VinculoRepository;
import br.dcc.trab3.demo.model.Item;
import br.dcc.trab3.demo.model.Usuario;
import br.dcc.trab3.demo.model.Vinculo;

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
    public String homeEtiqueta(Model model, HttpSession session){
        if(session.getAttribute("ativo") == null){
            model.addAttribute("usuario", new Usuario());
            return "redirect:/";
        }
        model.addAttribute("listItens", itens.findAll());
        return "item/item-index";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        return "item/item-form";
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarEtiqueta(@Valid Item item, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("item/item-form");
            mv.addObject("item", item);
            mv.addObject("listEtiquetas", etiquetas.findAll());
            return mv;
        }
        itens.save(item);
        mv.setViewName("redirect:/item/");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String preEditarEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("item", itens.findById(id).get());
        model.addAttribute("listEtiquetas", etiquetas.findAll());
        return "item/item-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarSalvaretiqueta(@Valid Item item, @PathVariable Long id, BindingResult binding){
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
        mv.setViewName("item/item-form");
        mv.addObject("item", item);
        mv.addObject("listEtiquetas", etiquetas.findAll());
       }
       mv.setViewName("redirect:/item/");
       itens.save(item);
       return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletarEtiqueta(@PathVariable Long id){
        itens.deleteById(id);
        return "redirect:/item/";
    }

    @RequestMapping("/controladorVinculo/{id}")
    public String gerenciarVinculo(@PathVariable Long id, Model model, HttpSession session) {
        session.setAttribute("idItem", id);
        Item item = itens.findById(id).get();
        List<Vinculo> listaVinculo = vinculos.findAllByItemOrigemOrItemDestino(item, item);
        model.addAttribute("item", item);
        model.addAttribute("listVinculo", listaVinculo);
        return "item/item-vinculos";
    }

    @RequestMapping("/deletarVinculo/{id}")
    public String deletarVinculo(@PathVariable Long id, HttpSession session) {
        Long idItem = (Long) session.getAttribute("idItem");
        vinculos.deleteById(id);
        return "redirect:/item/controladorVinculo/" + idItem;
    }
    
}