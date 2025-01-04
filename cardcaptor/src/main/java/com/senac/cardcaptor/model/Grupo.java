package com.senac.cardcaptor.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author elisa
 */
@Data
public class Grupo {

    private Integer id;
    private String nome;
    private List<Idol> idols;

    public Grupo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Grupo() {
    }

}
