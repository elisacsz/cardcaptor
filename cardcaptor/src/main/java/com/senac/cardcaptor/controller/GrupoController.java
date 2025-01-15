package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.service.GrupoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author elisa
 */
@Controller
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping("/grupos")
    public String index(Model model) {
        List<Grupo> listaGrupos = grupoService.listarGrupos();
        model.addAttribute("listaGrupos", listaGrupos);
        return "listaGrupos";
    }
}
