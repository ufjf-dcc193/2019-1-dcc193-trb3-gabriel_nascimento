package br.dcc.trab3.demo.controller;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ItemController
 */
@Controller
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
}