package br.dcc.trab3.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.model.Usuario;

/**
 * HomeController
 */

@Controller 
public class HomeController {

  @Autowired
  UsuarioRepository usuarios;

  @RequestMapping({"","/"})
  public String login(Model model){
    model.addAttribute("usuario", new Usuario());
    return "login";
  }

  @RequestMapping({"/home"})
  public String home(Model model){
    return "index";
  }

  @PostMapping("/efetuarLogin")
    public String login(Usuario usuario, Model model, HttpSession session){
        Usuario usuarioQuery = usuarios.findFirstByEmailAndCodigoAcesso(usuario.getEmail(),usuario.getCodigoAcesso());
        System.out.println(usuarioQuery.toString());
        if(usuarioQuery != null){
            session.setAttribute("ativo", usuarioQuery);
            return "redirect:/home";
        }else{
          return "redirect:/";
        }
    }

    @GetMapping("/sair")
    public String sair(Model model, HttpSession session){
      session.removeAttribute("ativo");
      model.addAttribute("usuario", new Usuario());
      return "redirect:/";
    }
  
}