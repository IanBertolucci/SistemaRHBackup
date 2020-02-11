package br.ufla.lemaf.ti.sistemarh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class HomeController {

    // TODO: logica da home/dashboard do site
    //  redirecionar para login caso usuario nao estiver autenticado

    public String home(){
        return "home";
    }
}
