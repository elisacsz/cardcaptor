package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.model.TipoPhotocard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhotocardController {

    private List<Grupo> listaGrupos;
    private List<Idol> listaIdols;
    private List<Photocard> listaPhotocards = new ArrayList<>();
    private int proximoIdPhotocard = 1;

    public PhotocardController() {
        listaGrupos = new ArrayList<>();

        Grupo aespa = new Grupo(1, "aespa");
        Grupo nct127 = new Grupo(2, "NCT 127");

        listaGrupos.add(aespa);
        listaGrupos.add(nct127);

        listaIdols = new ArrayList<>();

        listaIdols.add(new Idol(1, "Karina", aespa));
        listaIdols.add(new Idol(2, "Giselle", aespa));
        listaIdols.add(new Idol(3, "Winter", aespa));
        listaIdols.add(new Idol(4, "Ningning", aespa));

        listaIdols.add(new Idol(5, "Johnny", nct127));
        listaIdols.add(new Idol(6, "Taeyong", nct127));
        listaIdols.add(new Idol(7, "Yuta", nct127));
        listaIdols.add(new Idol(8, "Doyoung", nct127));
        listaIdols.add(new Idol(9, "Jaehyun", nct127));
        listaIdols.add(new Idol(10, "Jungwoo", nct127));
        listaIdols.add(new Idol(11, "Mark", nct127));
        listaIdols.add(new Idol(12, "Haechan", nct127));
    }

    @GetMapping("/")
    public String irParaInicio() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("listaGrupos", listaGrupos);
        model.addAttribute("listaIdols", listaIdols);
        model.addAttribute("tiposPhotocard", TipoPhotocard.values());
        model.addAttribute("photocard", new Photocard()); // ESSA LINHA É CRUCIAL!
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String processarFormulario(@ModelAttribute Photocard photocard, RedirectAttributes redirectAttributes) {
        photocard.setId(proximoIdPhotocard++);
        listaPhotocards.add(photocard);

        return "redirect:/detalhes?id=" + photocard.getId();
    }

}
