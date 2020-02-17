package br.ufla.lemaf.ti.sistemarh.services;

import br.ufla.lemaf.ti.sistemarh.entidades.Usuario;
import br.ufla.lemaf.ti.sistemarh.principal.UsuarioPrincipal;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioDetailsService implements UserDetailsService {

    private UsuarioRepo usuarioRepo;

    public UsuarioDetailsService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepo.findByUsername(s);
        UsuarioPrincipal usuarioPrincipal = new UsuarioPrincipal(usuario);
        return usuarioPrincipal;
    }
}
