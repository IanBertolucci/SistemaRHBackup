package br.ufla.lemaf.ti.sistemarh.entidades;

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

    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @NotNull
    @NotEmpty
    @Email(message = "Email inválido.")
    private String email;

//    @Size(min = 8, max = 64, message = "A senha deve conter entre 8 e 64 caracteres.")
    private String senha;

    private String roles = "";

    private String permissions = "";

    private int active;

    // constr, methods

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Usuario(String nome, String email, String senha, String permissions, String roles) {
        this.roles = roles;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissions = permissions;
        this.active = 1;
    }

    public Usuario() {
    }

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
