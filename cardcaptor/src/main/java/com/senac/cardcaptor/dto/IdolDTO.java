package com.senac.cardcaptor.dto;

/**
 *
 * @author elisa
 */
public class IdolDTO {

    private Integer id;
    private String nome;

    public IdolDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
