package br.ufla.lemaf.ti.sistemarh.entidades;

import javax.persistence.Entity;

@Entity
public class Usuario {

    private Long id;

    private String nome;

    private String email;

    private boolean ADM = false;



}
