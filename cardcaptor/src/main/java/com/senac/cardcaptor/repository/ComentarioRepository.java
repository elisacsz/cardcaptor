package com.senac.cardcaptor.repository;

import com.senac.cardcaptor.model.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elisa
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
    
    List<Comentario> findByPhotocardId(Integer photocardId);
}
