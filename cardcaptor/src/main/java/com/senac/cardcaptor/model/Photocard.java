package com.senac.cardcaptor.model;

import lombok.Data;

@Data
public class Photocard {
    
    private Integer id;
    private String nome;
    private TipoPhotocard tipo;
    private String loja;
    private String foto;
    private Grupo grupo;
    private Idol idol;
}