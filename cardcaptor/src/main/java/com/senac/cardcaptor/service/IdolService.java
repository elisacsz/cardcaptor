package com.senac.cardcaptor.service;

import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.repository.IdolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elisa
 */
@Service
public class IdolService {

    @Autowired
    private IdolRepository idolRepository;

    public List<Idol> listarIdolsPorGrupo(Integer grupoId) {
        return idolRepository.findByGrupoId(grupoId);
    }

    public List<Idol> listarTodosIdols() {
        return idolRepository.findAll();
    }

    public Idol buscarIdolPorId(Integer id) {
        return idolRepository.findById(id).orElseThrow();
    }

    public List<Idol> buscarIdolsPorNome(String nome) {
        return idolRepository.findByNome(nome);
    }
}