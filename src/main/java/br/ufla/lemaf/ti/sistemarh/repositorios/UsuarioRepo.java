package br.ufla.lemaf.ti.sistemarh.repositorios;

import br.ufla.lemaf.ti.sistemarh.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
