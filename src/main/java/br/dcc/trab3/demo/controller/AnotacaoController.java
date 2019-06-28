package br.dcc.trab3.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcc.trab3.demo.dao.AnotacaoRepository;
import br.dcc.trab3.demo.model.Anotacao;
import br.dcc.trab3.demo.model.Usuario;

/**
 * AnotacaoController
 */
@Controller
@RequestMapping("/anotacao/")
public class AnotacaoController {

    @Autowired
    AnotacaoRepository anotacoes;

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
        List<Usuario> listUsuario = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("ativo");
        listUsuario.add(usuario);
        model.addAttribute("anotacao", new Anotacao());
        model.addAttribute("listUsuario", listUsuario);
        return "anotacao/anotacao-form";
    }
    
}