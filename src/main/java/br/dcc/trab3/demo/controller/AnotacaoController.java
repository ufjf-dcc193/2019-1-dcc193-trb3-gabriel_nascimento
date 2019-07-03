package br.dcc.trab3.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.dao.VinculoRepository;
import br.dcc.trab3.demo.model.Anotacao;
import br.dcc.trab3.demo.model.Item;
import br.dcc.trab3.demo.model.Usuario;

/**
 * AnotacaoController
 */
@Controller
@RequestMapping("/anotacao/")
public class AnotacaoController {

    @Autowired
    AnotacaoRepository anotacoes;

    @Autowired
    ItemRepository itens;

    @Autowired
    VinculoRepository vinculos;

    @RequestMapping("")
    public String homeEtiqueta(Model model, HttpSession session){
        if(session.getAttribute("ativo") == null){
            model.addAttribute("usuario", new Usuario());
            return "redirect:/";
        }
        model.addAttribute("listAnotacoes", anotacoes.findAll());
        return "anotacao/anotacao-index";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model, HttpSession session){
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Usuario> listUsuario = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("ativo");
        listUsuario.add(usuario);
        Anotacao anotacao = new Anotacao();
        anotacao.setDataInclusao(sdf.format(data));
        model.addAttribute("anotacao", anotacao);
        model.addAttribute("listUsuario", listUsuario);
        model.addAttribute("listVinculos", vinculos.findAll());
        model.addAttribute("listItens", itens.findAll());
        return "anotacao/anotacao-form";
    }

    @RequestMapping("/criarAnotacaoItem/{id}")
    public String criarAnotacaoItem(@PathVariable Long id, Model model, HttpSession session){
        Item item = itens.findById(id).get();
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Usuario> listUsuario = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("ativo");
        listUsuario.add(usuario);
        Anotacao anotacao = new Anotacao();
        anotacao.setItem(item);
        anotacao.setDataInclusao(sdf.format(data));
        model.addAttribute("anotacao", anotacao);
        model.addAttribute("listUsuario", listUsuario);
        return "anotacao/anotacao-form-item";
    }


    @PostMapping("/salvar")
    public ModelAndView salvarAnotacao(@Valid Anotacao anotacao, BindingResult binding, HttpSession session){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("anotacao/anotacao-form");
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Usuario> listUsuario = new ArrayList<>();
            Usuario usuario = (Usuario) session.getAttribute("ativo");
            listUsuario.add(usuario);
            anotacao.setDataInclusao(sdf.format(data));
            mv.addObject("anotacao", anotacao);
            mv.addObject("listUsuario", listUsuario);
            return mv;
        }
        anotacoes.save(anotacao);
        mv.setViewName("redirect:/anotacao/");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String editarRevisao(@PathVariable Long id, Model model, HttpSession session){
        List<Usuario> listUsuario = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("ativo");
        listUsuario.add(usuario);
        Anotacao anotacao = anotacoes.findById(id).get();
        model.addAttribute("anotacao", anotacao);
        model.addAttribute("listUsuario", listUsuario);
        return "anotacao/anotacao-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarAnotacaoSubmit(@Valid Anotacao anotacao, @PathVariable Long id, HttpSession session, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if(binding.hasErrors()){
            mv.setViewName("anotacao/anotacao-edit"); 
            List<Usuario> listUsuario = new ArrayList<>();
            Usuario usuario = (Usuario) session.getAttribute("ativo");
            listUsuario.add(usuario);
            mv.addObject("anotacao", anotacao);
            mv.addObject("listUsuario", listUsuario);
            return mv;
        }
        anotacao.setDataAlteracao(sdf.format(data));
        mv.setViewName("redirect:/anotacao/"); 
        anotacoes.save(anotacao);
        return mv;
    }

    @RequestMapping("/deletar/{id}")
    public String deletarAnotacao(@PathVariable Long id){
        anotacoes.deleteById(id);
        return "redirect:/anotacao/";
    }

    
}