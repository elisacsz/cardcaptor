package com.senac.cardcaptor.service;

import com.senac.cardcaptor.model.Comentario;
import com.senac.cardcaptor.repository.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elisa
 */
@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public Comentario buscarPorId(Integer id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    public Comentario criar(Comentario comentario) {
        comentario.setId(null);
        comentarioRepository.save(comentario);
        return comentario;
    }

    public List<Comentario> listarComentariosPorPhotocard(Integer photocardId) {
        return comentarioRepository.findByPhotocardId(photocardId);
    }

}
