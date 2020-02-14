package br.ufla.lemaf.ti.sistemarh.entidades;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotEmpty
    @NotNull
    private String username;

    @NotNull
    @NotEmpty
    @Email
    private String email; //email

// TODO:   @Size(min = 8, max = 64, message = "A senha deve conter entre 8 e 64 caracteres.")
    private String senha;

    private String roles = "";

    private String permissions = "";

    // constr, methods

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    // methods

    public Usuario(String username, String nome, String email, String senha, String permissions, String roles) {
        this.roles = roles;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.permissions = permissions;
    }

    protected Usuario(){}

    public List<String> getRoleList(){
        if (this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionsList(){
        if (this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
