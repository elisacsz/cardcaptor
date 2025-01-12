package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Comentario;
import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.model.TipoPhotocard;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhotocardController {

    /*private List<Grupo> listaGrupos;
    private List<Idol> listaIdols;
    private List<Photocard> listaPhotocards = new ArrayList<>();
    private List<Comentario> listaComentarios = new ArrayList<>();
    private List<Photocard> listaDesejos = new ArrayList<>();
    private int proximoIdPhotocard = 1;
    private int proximoIdComentario = 1;

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
    }*/

    @GetMapping("/")
    public String irParaInicio() {
        return "index";
    }

    /*@GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("listaGrupos", listaGrupos);
        model.addAttribute("listaIdols", listaIdols);
        model.addAttribute("tiposPhotocard", TipoPhotocard.values());
        model.addAttribute("photocard", new Photocard());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String processarFormulario(
            @ModelAttribute Photocard photocard,
            @RequestParam("grupoId") Integer grupoId,
            @RequestParam("idolId") Integer idolId
    ) {

        Grupo grupo = null;
        for (Grupo g : listaGrupos) {
            if (g.getId().equals(grupoId)) {
                grupo = g;
                break;
            }
        }

        Idol idol = null;
        for (Idol i : listaIdols) {
            if (i.getId().equals(idolId)) {
                idol = i;
                break;
            }
        }

        if (grupo == null || idol == null) {
            return "erro";
        }

        photocard.setGrupo(grupo);
        photocard.setIdol(idol);

        photocard.setId(proximoIdPhotocard++);

        listaPhotocards.add(photocard);

        return "redirect:/photocard/" + photocard.getId();
    }

    //----------------------------------------------------------------Photocard
    @GetMapping("/photocard/{id}")
    public String detalhesPhotocard(@PathVariable Integer id, Model model) {
        Photocard photocard = null;
        for (Photocard p : listaPhotocards) {
            if (p.getId().equals(id)) {
                photocard = p;
                break;
            }
        }

        model.addAttribute("photocard", photocard);
        model.addAttribute("listaIdols", listaIdols);
        model.addAttribute("listaGrupos", listaGrupos);
        model.addAttribute("listaComentarios", listaComentarios != null ? listaComentarios : new ArrayList<>());
        model.addAttribute("novoComentario", new Comentario());

        return "photocard";
    }

    @PostMapping("/comentar/{photocardId}")
    public String comentar(@PathVariable Integer photocardId, @ModelAttribute Comentario novoComentario) {
        Photocard photocard = null;
        for (Photocard p : listaPhotocards) {
            if (p.getId().equals(photocardId)) {
                photocard = p;
                break;
            }
        }

        if (photocard != null) {
            novoComentario.setPhotocard(photocard);
            listaComentarios.add(novoComentario);
        }

        return "redirect:/photocard/" + photocard.getId();
    }

    //----------------------------------------------------------------Listas
    

    

    //Listar photocards    
    @GetMapping("/idol/{id}")
    public String listarPhotocardsPorIdol(@PathVariable Integer id, Model model) {
        Idol idolSelecionado = null;
        List<Photocard> photocardsIdolSelecionado = new ArrayList<>();

        for (Idol idol : listaIdols) {
            if (idol.getId().equals(id)) {
                idolSelecionado = idol;
                break;
            }
        }

        if (idolSelecionado != null) {
            for (Photocard photocard : listaPhotocards) {
                if (photocard.getIdol().getId().equals(id)) {
                    photocardsIdolSelecionado.add(photocard);
                }
            }
            model.addAttribute("idol", idolSelecionado);
            model.addAttribute("listaPhotocards", photocardsIdolSelecionado);
        }

        return "listaPhotocards";
    }

    @PostMapping("/removerPhotocard/{id}")
    public String removerPhotocard(@PathVariable Integer id) {
        Photocard photocardRemovido = null;
        for (Photocard p : listaPhotocards) {
            if (p.getId().equals(id)) {
                photocardRemovido = p;
                break;
            }
        }

        if (photocardRemovido != null) {
            listaPhotocards.remove(photocardRemovido);
        }

        return "redirect:/idol/" + photocardRemovido.getIdol().getId();
    }*/
    
}
