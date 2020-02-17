package br.ufla.lemaf.ti.sistemarh.entidades;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id", nullable = false)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "usr_username", nullable = false)
    private String username;

    @NotNull
    @NotEmpty
    @Column(name = "usr_senha", nullable = false)
    private String senha;

    @NotEmpty
    @NotNull
    @Column(name = "usr_nome", nullable = false)
    private String nome;

    @NotNull
    @NotEmpty
    @Email
    @Column(name = "usr_email", nullable = false)
    private String email;

    @Column(name = "usr_roles", nullable = false)
    private String roles = "";

    @Column(name = "usr_permissions", nullable = false)
    private String permissions = "";

    // getter, setter, constructor

    public Usuario(String username, String nome, String email, String senha, String permissions, String roles) {
        this.roles = roles;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.permissions = permissions;
    }

    protected Usuario(){}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    // methods

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
