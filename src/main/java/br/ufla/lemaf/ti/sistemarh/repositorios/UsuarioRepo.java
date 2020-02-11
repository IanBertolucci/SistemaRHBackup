package br.ufla.lemaf.ti.sistemarh.repositorios;

import br.ufla.lemaf.ti.sistemarh.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
