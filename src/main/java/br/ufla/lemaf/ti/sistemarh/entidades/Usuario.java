package br.ufla.lemaf.ti.sistemarh.entidades;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @Email(message = "Insira um email válido.")
    private String email;

    @Size(min = 8, max = 64, message = "A senha deve conter entre 8 e 64 caracteres.")
    private String senha;

    @NotNull
    private int role; //0 = adm, 1 = usr

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
