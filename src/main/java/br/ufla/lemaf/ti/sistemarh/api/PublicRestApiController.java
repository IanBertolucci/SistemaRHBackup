package br.ufla.lemaf.ti.sistemarh.api;

import br.ufla.lemaf.ti.sistemarh.model.Usuario;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
    private UsuarioRepo usuarioRepositorio;

    public PublicRestApiController(UsuarioRepo usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Available to all authenticated users
    @GetMapping("test")
    public String test1(){
        return "API Test";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<Usuario> usuarios(){
        return this.usuarioRepositorio.findAll();
    }
}
