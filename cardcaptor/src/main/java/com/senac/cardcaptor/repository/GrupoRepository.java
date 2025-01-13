package com.senac.cardcaptor.repository;

import com.senac.cardcaptor.model.Grupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elisa
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    @Query("SELECT g.nome FROM Grupo g")
    List<String> findAllNomes();

    List<Grupo> findByNome(String nome);
}
