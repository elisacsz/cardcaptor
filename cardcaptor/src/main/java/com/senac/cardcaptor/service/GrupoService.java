package com.senac.cardcaptor.service;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.repository.GrupoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elisa
 */
@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<String> listarNomesDeGrupos() {
        return grupoRepository.findAllNomes();
    }

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo buscarGrupoPorId(Integer id) {
        return grupoRepository.findById(id).orElse(null);
    }

    public List<Grupo> buscarGruposPorNome(String nome) {
        return grupoRepository.findByNome(nome);
    }
}