package com.senac.cardcaptor.repository;

import com.senac.cardcaptor.model.Idol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elisa
 */
@Repository
public interface IdolRepository extends JpaRepository<Idol, Integer> {

    List<Idol> findByGrupoId(Integer grupoId);
    
    List<Idol> findByNome(String nome);
}
