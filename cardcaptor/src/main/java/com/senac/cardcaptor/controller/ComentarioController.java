package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Comentario;
import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.service.ComentarioService;
import com.senac.cardcaptor.service.PhotocardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author elisa
 */
@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    PhotocardService photocardService;

    @Autowired
    ComentarioService comentarioService;

    @PostMapping("/comentar/{photocardId}")
    public String comentar(@PathVariable Integer photocardId, @Valid @ModelAttribute("novoComentario") Comentario novoComentario, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        Photocard photocard = photocardService.buscarPorId(photocardId);

        novoComentario.setPhotocard(photocard);
        comentarioService.criar(novoComentario);

        return "redirect:/photocards/photocard/" + photocardId;
    }
}
