package br.ufla.lemaf.ti.sistemarh.controllers;

import br.ufla.lemaf.ti.sistemarh.entidades.Usuario;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class CadastroController {

    @Autowired
    UsuarioRepo repositorio;

    @GetMapping("cadastro")
    public ModelAndView cadastrar() {
        ModelAndView resultado = new ModelAndView("form/cadastro");
        Usuario usuario = new Usuario("", "", "", "", "", "");
        resultado.addObject("usuario", usuario);
        return resultado;
    }

    @PostMapping("cadastro")
    public String cadastrar(Usuario usuario) {
        try {
            repositorio.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/index/index";
    }
}
