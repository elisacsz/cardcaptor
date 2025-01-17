package com.senac.cardcaptor.service;

import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.repository.PhotocardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elisa
 */
@Service
public class PhotocardService {

    @Autowired
    PhotocardRepository photocardRepository;

    public Photocard criar(Photocard photocard) {
        photocard.setId(null);
        photocardRepository.save(photocard);
        return photocard;
    }

    public Photocard buscarPorId(Integer id) {
        return photocardRepository.findById(id).orElse(null);
    }

    public List<Photocard> listarPhotocardsPorIdol(Integer idolId) {
        return photocardRepository.findByIdolId(idolId);
    }

    public void excluir(Integer id) {
        photocardRepository.deleteById(id);
    }
}
