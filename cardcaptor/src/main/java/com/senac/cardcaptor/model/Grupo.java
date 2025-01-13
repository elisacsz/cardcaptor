package com.senac.cardcaptor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author elisa
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Idol> idols;
    
    @OneToMany(mappedBy = "grupo")
    private List<Photocard> photocards;

    public Grupo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Grupo(Integer id) {
        this.id = id;
    }

}
