package br.ufla.lemaf.ti.sistemarh.security;

import br.ufla.lemaf.ti.sistemarh.repositorios.UsuarioRepo;
import br.ufla.lemaf.ti.sistemarh.services.UsuarioDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UsuarioDetailsService usuarioDetailsService;
    private UsuarioRepo usuarioRepo;

    public SecurityConfig(UsuarioDetailsService usuarioDetailsService, UsuarioRepo usuarioRepo) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // configurando JWT para funcioanr com a aplicação
                // TODO: testar form login
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.usuarioRepo))
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers("/index").permitAll()
                    .antMatchers("/form/**").permitAll()
                    .antMatchers("/cadastro").permitAll()
                    .antMatchers("/user").authenticated()
                    .antMatchers("/admin").hasRole("ADMIN")
//                    .and()
//                .formLogin()
//                    .loginProcessingUrl("/signin")
//                    .loginPage("/login").permitAll() // TODO: mudar para view do vue
//                    .defaultSuccessUrl("/home")
//                    .usernameParameter("txtUsername")
//                    .passwordParameter("txtPassword")
//                    .and()
//                .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .logoutSuccessUrl("/login")
                    ;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);

        return daoAuthenticationProvider;
    }
}
