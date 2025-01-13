package com.senac.cardcaptor.repository;

import com.senac.cardcaptor.model.Photocard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elisa
 */
@Repository
public interface PhotocardRepository extends JpaRepository<Photocard,Integer>{

        List<Photocard> findByIdolId(Integer idolId);
    
}
