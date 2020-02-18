package br.ufla.lemaf.ti.sistemarh.services;

import br.ufla.lemaf.ti.sistemarh.model.Usuario;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInitService implements CommandLineRunner {
    private UsuarioRepo usuarioRepo;
    PasswordEncoder passwordEncoder;


    public DbInitService(UsuarioRepo usuarioRepo, PasswordEncoder passwordEncoder){
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    //TODO: teste apenas, remover depois
    @Override
    public void run(String... args){
        this.usuarioRepo.deleteAll();

        Usuario user = new Usuario("user", "usuario jr", "user@user.com", passwordEncoder.encode("123"), "", "USER");
        Usuario admin = new Usuario("admin", "admnistrador sr", "admin@admin.com", passwordEncoder.encode("123"), "", "ADMIN");

        List<Usuario> usuarios = Arrays.asList(user, admin);
        this.usuarioRepo.saveAll(usuarios);
    }


}
