package br.ufla.lemaf.ti.sistemarh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public String mensagemController(Model model){

        model.addAttribute("mensagem", "mensagem do controller");

        return "index";
    }
}
