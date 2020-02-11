package br.ufla.lemaf.ti.sistemarh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    // TODO: logica da home/dashboard do site
    //  redirecionar para login caso usuario nao estiver autenticado

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("mensagem", "Bem vindo!");
        return "home";
    }
}
