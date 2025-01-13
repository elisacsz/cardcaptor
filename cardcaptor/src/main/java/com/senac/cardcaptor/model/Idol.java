package com.senac.cardcaptor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Idol")
public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    
    @OneToMany(mappedBy = "idol")
    private List<Photocard> photocards;

}
