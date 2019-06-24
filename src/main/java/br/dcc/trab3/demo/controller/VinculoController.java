package br.dcc.trab3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcc.trab3.demo.dao.VinculoRepository;

/**
 * VinculoController
 */
@Controller
@RequestMapping("/vinculo/")
public class VinculoController {

    @Autowired
    VinculoRepository vinculos;

    @RequestMapping("")
    public String homeVinculo(Model model){
        model.addAttribute("listVinculos", vinculos.findAll());
        return "vinculo/vinculo-index";
    }

    
    
}