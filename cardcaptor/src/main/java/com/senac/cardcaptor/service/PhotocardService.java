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

    public List<Photocard> buscarTodos() {
        return photocardRepository.findAll();
    }

    public void excluir(Integer id) {
        //Photocard photocardEncontrado = buscarPorId(id);
        //photocardRepository.deleteById(photocardEncontrado.getId());
        photocardRepository.deleteById(id);
    }

    public Photocard buscarPorId(Integer id) {
        return photocardRepository.findById(id).orElse(null);
    }
}
