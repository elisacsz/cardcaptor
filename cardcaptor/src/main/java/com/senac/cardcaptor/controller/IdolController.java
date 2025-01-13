package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elisa
 */
@RestController
public class IdolController {
    /*
    //Listar membros do grupo selecionado
    @GetMapping("/grupos/{id}")
    public String listarIdolsPorGrupo(@PathVariable Integer id, Model model) {
        Grupo grupoSelecionado = null;

        for (Grupo grupo : listaGrupos) {
            if (grupo.getId().equals(id)) {
                grupoSelecionado = grupo;
                break;
            }
        }

        List<Idol> idolsGrupoSelecionado = new ArrayList<>();

        if (grupoSelecionado != null) {
            for (Idol idol : listaIdols) {
                if (idol.getGrupo().getId().equals(id)) {
                    idolsGrupoSelecionado.add(idol);
                }
            }

            model.addAttribute("grupo", grupoSelecionado);
            model.addAttribute("listaIdols", idolsGrupoSelecionado);
        } else {
            model.addAttribute("grupo", null);
            model.addAttribute("listaIdols", new ArrayList<>());
        }

        return "listaIdols";
    }*/
}
