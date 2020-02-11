package br.ufla.lemaf.ti.sistemarh.entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private int role; //0 = adm, 1 = usr



}
