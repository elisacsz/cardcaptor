package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.service.GrupoService;
import com.senac.cardcaptor.service.IdolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author elisa
 */
@Controller
public class IdolController {

    @Autowired
    GrupoService grupoService;

    @Autowired
    IdolService idolService;

    @GetMapping("/grupos/{grupoId}/idols")
    public String listarIdolsDoGrupo(@PathVariable Integer grupoId, Model model) {
        Grupo grupo = grupoService.buscarGrupoPorId(grupoId);

        List<Idol> listaIdols = idolService.listarIdolsPorGrupo(grupoId);

        model.addAttribute("grupo", grupo);
        model.addAttribute("listaIdols", listaIdols);
        return "listaIdols";
    }
}
