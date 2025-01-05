package com.senac.cardcaptor.model;

import lombok.Data;

/**
 *
 * @author elisa
 */
@Data
public class Comentario {
    
    private Integer id;    
    private String comentario;
    private Photocard photocard;
    
}
