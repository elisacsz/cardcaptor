package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Comentario;
import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.model.Photocard;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author elisa
 */
@Controller
public class PhotocardController {

    private List<Grupo> listaGrupos;
    private List<Idol> listaIdols;
    private List<Photocard> listaPhotocards = new ArrayList<>();
    private List<Comentario> listaComentarios = new ArrayList<>();
    private int proximoIdPhotocard = 1;
    private int proximoIdComentario = 1;

    //Lista dos grupos e idols de cada grupo
    public PhotocardController() {
        listaGrupos = new ArrayList<>();
        listaGrupos.add(new Grupo(1, "aespa"));
        listaGrupos.add(new Grupo(2, "NCT 127"));

        listaIdols = new ArrayList<>();

        //aespa
        listaIdols.add(new Idol(1, "Karina", new Grupo(1)));
        listaIdols.add(new Idol(2, "Giselle", new Grupo(1)));
        listaIdols.add(new Idol(3, "Winter", new Grupo(1)));
        listaIdols.add(new Idol(4, "Ningning", new Grupo(1)));

        //NCT 127
        listaIdols.add(new Idol(5, "Johnny", new Grupo(2)));
        listaIdols.add(new Idol(6, "Taeyong", new Grupo(2)));
        listaIdols.add(new Idol(7, "Yuta", new Grupo(2)));
        listaIdols.add(new Idol(8, "Doyoung", new Grupo(2)));
        listaIdols.add(new Idol(9, "Jaehyun", new Grupo(2)));
        listaIdols.add(new Idol(10, "Jungwoo", new Grupo(2)));
        listaIdols.add(new Idol(11, "Mark", new Grupo(2)));
        listaIdols.add(new Idol(12, "Haechan", new Grupo(2)));
    }

    @GetMapping("/")
    public String irParaInicio() {
        return "index";
    }

    //Página de cadastro de photocards
    @GetMapping("/cadastro")
    public String exibirFormulario(@RequestParam(value = "grupo", required = false) Integer grupoId, Model model) {
        List<Idol> idolsFiltrados;
        
        //Para filtrar os idols pelo grupo que foi selecionado, se não selecionar nenhum, aparece todos os idols na lista
        if (grupoId != null) {
            idolsFiltrados = listaIdols.stream()
                    .filter(idol -> idol.getGrupo().getId().equals(grupoId))
                    .collect(Collectors.toList());
        } else {
            idolsFiltrados = listaIdols;
        }

        model.addAttribute("photocard", new Photocard());
        model.addAttribute("listaGrupos", listaGrupos);
        model.addAttribute("listaIdols", idolsFiltrados);
        return "cadastro";
    }
    
    //Filtrar os idols por grupo
    @PostMapping("/filtrarIdols")
    public String filtrarIdols(@RequestParam(value = "grupoId", required = false) Integer grupoId, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("photocard", new Photocard());
        model.addAttribute("listaGrupos", listaGrupos);

        List<Idol> listaIdolsFiltrada = filtrarIdolsPorGrupo(grupoId == null ? null : new Grupo(grupoId));

        model.addAttribute("listaIdols", listaIdolsFiltrada);
        return "cadastro";
    }
    
        private List<Idol> filtrarIdolsPorGrupo(Grupo grupo) {
        if (grupo == null || grupo.getId() == null) {
            return listaIdols;
        }
        return listaIdols.stream()
                .filter(idol -> idol.getGrupo().getId().equals(grupo.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/processarFormulario")
    public String processarFormulario(@ModelAttribute Photocard photocard, RedirectAttributes redirectAttributes) {
        photocard.setId(proximoIdPhotocard++);
        listaPhotocards.add(photocard);
        return "redirect:/detalhes?id=" + photocard.getId();
    }
    
}
