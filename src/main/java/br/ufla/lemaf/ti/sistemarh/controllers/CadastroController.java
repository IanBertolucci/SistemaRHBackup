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
@RequestMapping("/usr")
public class CadastroController {

    @Autowired
    UsuarioRepo repositorio;

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView perfil = new ModelAndView("/cadastro/cadastro");
        perfil.addObject("usuario", new Usuario());
        return perfil;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Usuario usuario){
        repositorio.save(usuario);
        return "redirect:/dashboard";
    }

}
