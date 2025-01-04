package com.senac.cardcaptor.model;

import lombok.Data;

/**
 *
 * @author elisa
 */

@Data
public class Idol {
    
    private Integer id;
    private String nome;
    private Grupo grupo;

    public Idol(Integer id, String nome, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.grupo = grupo;
    }

    public Idol() {
    }
    
}
