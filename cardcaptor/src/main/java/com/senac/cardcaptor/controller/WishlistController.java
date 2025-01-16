package com.senac.cardcaptor.controller;

import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.model.Wishlist;
import com.senac.cardcaptor.repository.WishlistRepository;
import com.senac.cardcaptor.service.PhotocardService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author elisa
 */
@Controller
public class WishlistController {

    @Autowired
    private PhotocardService photocardService;

    @Autowired
    private WishlistRepository wishlistRepository;

    @PostMapping("/adicionarAWishlist/{id}")
    public String adicionarAWishlist(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Wishlist wishlist = wishlistRepository.findFirstBy();

        if (wishlist == null) {
            wishlist = new Wishlist();
            wishlistRepository.save(wishlist);
        }

        Photocard photocard = photocardService.buscarPorId(id);
        if (photocard == null) {
            redirectAttributes.addFlashAttribute("mensagem", "Photocard não encontrado!");
            return "redirect:/error";
        }

        List<Photocard> photocards = wishlist.getPhotocards();
        if (photocards == null) {
            wishlist.setPhotocards(new ArrayList<>());
            photocards = wishlist.getPhotocards();
        }
        photocards.add(photocard);
        wishlistRepository.save(wishlist);
        Integer idolId = photocard.getIdol().getId();
        return "redirect:/idols/" + idolId + "/photocards";
    }

    @GetMapping("/wishlist")
    public String exibirWishlist(Model model) {
        Wishlist wishlist = wishlistRepository.findFirstBy();
        if (wishlist == null) {
            wishlist = new Wishlist();
            wishlistRepository.save(wishlist);
        }
        model.addAttribute("wishlist", wishlist.getPhotocards());
        return "wishlist";
    }
    
     @PostMapping("/removerPhotocardWishlist/{id}")
    public String removerPhotocardWishlist(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Wishlist wishlist = wishlistRepository.findFirstBy();
        if (wishlist == null) {
            return "redirect:/wishlist";
        }

        Photocard photocard = photocardService.buscarPorId(id);

        List<Photocard> photocards = wishlist.getPhotocards();
        if (photocards != null) {
            photocards.remove(photocard);
            wishlistRepository.save(wishlist);
        }

        return "redirect:/wishlist";
    }
}
