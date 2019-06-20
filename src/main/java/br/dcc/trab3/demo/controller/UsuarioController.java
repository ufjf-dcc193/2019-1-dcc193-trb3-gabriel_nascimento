package br.dcc.trab3.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.model.Usuario;

/**
 * UsuarioController
 */
@Controller
@RequestMapping("/usuario/")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarios;

    @RequestMapping("")
    public String homeUsuario(Model model){
        model.addAttribute("listUsuarios", usuarios.findAll());
        return "usuario/usuario-index";
    }

    @RequestMapping("/criar")
    public String criarUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuario-form";
    }

    @PostMapping("/salvar")
    public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("usuario/usuario-form");
            mv.addObject("usuario", usuario);
            return mv;
        }
        usuarios.save(usuario);
        mv.setViewName("usuario/");
        return mv;
    }

    @RequestMapping("/editar/{id}")
    public String preEditarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario",usuarios.findById(id).get());
        return "usuario/usuario-edit";
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarSalvarUsuario(@Valid Usuario usuario, @PathVariable Long id, BindingResult binding){
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
           mv.setViewName("usuario/usuario-edit");
           mv.addObject("usuario", usuario);
           return mv;
       }
       mv.setViewName("/usuario/");
       usuarios.save(usuario);
       return mv;
    }

    @RequestMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id){
        usuarios.deleteById(id);
        return "redirect:/usuario/";
    }
    
}