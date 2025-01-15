package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.dto.IdolDTO;
import com.senac.cardcaptor.model.Comentario;
import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.service.ComentarioService;
import com.senac.cardcaptor.service.GrupoService;
import com.senac.cardcaptor.service.IdolService;
import com.senac.cardcaptor.service.PhotocardService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/photocards")
public class PhotocardController {

    @Autowired
    PhotocardService photocardService;

    @Autowired
    GrupoService grupoService;

    @Autowired
    IdolService idolService;

    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/")
    public String irParaInicio() {
        return "index";
    }

    //CADASTRO
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        List<Grupo> grupos = grupoService.listarGrupos();
        List<Idol> idols = idolService.listarIdols();

        model.addAttribute("photocard", new Photocard());
        model.addAttribute("grupos", grupos);
        model.addAttribute("idols", idols);
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvarPhotocard(@ModelAttribute Photocard photocard, @RequestParam("grupoId") Integer grupoId, @RequestParam("idolId") Integer idolId) {
        Grupo grupo = grupoService.buscarGrupoPorId(grupoId);
        Idol idol = idolService.buscarIdolPorId(idolId);

        photocard.setGrupo(grupo);
        photocard.setIdol(idol);

        Photocard photocardSalvo = photocardService.criar(photocard);

        return "redirect:/photocards/photocard/" + photocardSalvo.getId();
    }

    //PRA LISTAR OS IDOLS DE UM GRUPO ESPECIFICO
    @GetMapping("/idolsPorGrupo")
    @ResponseBody
    public List<IdolDTO> listarIdolsPorGrupo(@RequestParam(required = false) Integer grupoId) {
        if (grupoId == null) {
            return Collections.emptyList();
        }

        List<Idol> idols = idolService.listarIdolsPorGrupo(grupoId);

        List<IdolDTO> idolDTOs = new ArrayList<>();

        if (idols != null) {
            for (Idol idol : idols) {
                if (idol != null) {
                    IdolDTO idolDTO = new IdolDTO(idol.getId(), idol.getNome());
                    idolDTOs.add(idolDTO);
                }
            }
        }

        return idolDTOs;
    }

    
    //MOSTRAR DETALHES DO PC
    @GetMapping("/photocard/{id}")
    public String detalhesPhotocard(@PathVariable Integer id, Model model) {
        Photocard photocard = photocardService.buscarPorId(id);

        if (photocard != null) {
            List<Comentario> comentarios = comentarioService.listarComentariosPorPhotocard(photocard.getId());
            model.addAttribute("photocard", photocard);
            model.addAttribute("listaComentarios", comentarios);
            model.addAttribute("novoComentario", new Comentario());
        } else {
            model.addAttribute("errorMessage", "Photocard não encontrado."); // Mensagem de erro
        }
        return "photocard";
    }

    /*//LISTAR
    @GetMapping("/lista")
    public String listarPhotocards(Model model) {
        List<Photocard> photocards = photocardService.buscarTodos();
        model.addAttribute("photocards", photocards);
        return "listaPhotocards";
    }

    //REMOVER    
    @PostMapping("/removerPhotocard/{id}")
    public String removerPhotocard(@PathVariable Integer id) {
        photocardService.excluir(id);

        return "redirect:/idol/" + photocardRemovido.getIdol().getId();
    }*/
}
