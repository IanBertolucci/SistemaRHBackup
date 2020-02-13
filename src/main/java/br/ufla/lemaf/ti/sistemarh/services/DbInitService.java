package br.ufla.lemaf.ti.sistemarh.services;

import br.ufla.lemaf.ti.sistemarh.entidades.Usuario;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInitService implements CommandLineRunner {
    private UsuarioRepo usuarioRepo;

    public DbInitService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    //TODO: teste apenas, remover depois
    @Override
    public void run(String... args){
        Usuario user = new Usuario("user", "user@user.com", "123", "", "USER");
        Usuario admin = new Usuario("admin", "admin@admin.com", "123", "", "ADMIN");

        List<Usuario> usuarios = Arrays.asList(user, admin);
        this.usuarioRepo.saveAll(usuarios);
    }


}
