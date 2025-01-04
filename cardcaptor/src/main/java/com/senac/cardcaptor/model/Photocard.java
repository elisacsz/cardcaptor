package com.senac.cardcaptor.model;

import lombok.Data;

/**
 *
 * @author elisa
 */
@Data
public class Photocard {
    
    private Integer id;
    private String nome; //Nome da era, ou do merch, etc (obrigatório, entrada do usuário)
    private String tipo; //Se é regular, POB, fansign (lista de seleção)
    private String loja; //Se for pob ou fansign, tem que ter o nome da loja (entrada do usuário)
    private String foto; //Foto do photocard (obrigatória)    
    private Grupo grupo;
    private Idol idol; //Obrigatória, lista de seleção    
}