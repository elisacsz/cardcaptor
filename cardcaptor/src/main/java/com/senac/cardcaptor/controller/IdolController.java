package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Grupo;
import com.senac.cardcaptor.model.Idol;
import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.service.GrupoService;
import com.senac.cardcaptor.service.IdolService;
import com.senac.cardcaptor.service.PhotocardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    PhotocardService photocardService;

    @GetMapping("/grupos/{grupoId}/idols")
    public String listarIdolsDoGrupo(@PathVariable Integer grupoId, Model model) {
        Grupo grupo = grupoService.buscarGrupoPorId(grupoId);

        List<Idol> listaIdols = idolService.listarIdolsPorGrupo(grupoId);

        model.addAttribute("grupo", grupo);
        model.addAttribute("listaIdols", listaIdols);
        return "listaIdols";
    }

    //LISTAR OS PHOTOCARDS POR IDOL
    @GetMapping("/idols/{idolId}/photocards")
    public String listarPhotocardsDoIdol(@PathVariable Integer idolId, Model model) {
        Idol idol = idolService.buscarIdolPorId(idolId);
        if (idol == null) {
            System.out.println("Idol não encontrado com ID: " + idolId);
            return "redirect:/";
        }
        List<Photocard> listaPhotocards = photocardService.listarPhotocardsPorIdol(idolId);
        if (listaPhotocards.isEmpty()) {
            System.out.println("Nenhum photocard encontrado para o idol ID: " + idolId);
        }

        model.addAttribute("idol", idol);
        model.addAttribute("listaPhotocards", listaPhotocards);
        return "listaPhotocards";
    }

    //REMOVER PHOTOCARD
    @PostMapping("/removerPhotocard/{id}")
    public String removerPhotocard(@PathVariable Integer id, @RequestParam("idolId") Integer idolId, RedirectAttributes redirectAttributes) {
        try {
            photocardService.excluir(id);
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Você precisa remover o photocard da sua Wishlist antes de excluir :)");
        }
        return "redirect:/idols/" + idolId + "/photocards";
    }
}
