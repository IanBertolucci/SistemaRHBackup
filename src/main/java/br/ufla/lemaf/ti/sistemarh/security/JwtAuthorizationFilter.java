package br.ufla.lemaf.ti.sistemarh.security;

import br.ufla.lemaf.ti.sistemarh.model.Usuario;
import br.ufla.lemaf.ti.sistemarh.principal.UsuarioPrincipal;
import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import com.auth0.jwt.JWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UsuarioRepo usuarioRepo;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UsuarioRepo usuarioRepo) {
        super(authenticationManager);
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Request para ler o token JWT que deve estar presente
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        // Caso não haja token, dá kill na aplicação do usuário
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // Caso haja, tenta procurar o usuário com essa autorização
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX,"");

        if (token != null) {
            // Valida o token
            String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            // Procura no banco o usuário com o parâmetro indicado (username)
            // Caso haja, cria token do spring de autorização
            if (userName != null) {
                Usuario usuario = usuarioRepo.findByUsername(userName);
                UsuarioPrincipal principal = new UsuarioPrincipal(usuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
                return auth;
            }
            return null;
        }
        return null;
    }
}
