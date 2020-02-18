package br.ufla.lemaf.ti.sistemarh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String mensagemController(Model model){

        model.addAttribute("mensagem", "user");

        return "user";
    }
}
