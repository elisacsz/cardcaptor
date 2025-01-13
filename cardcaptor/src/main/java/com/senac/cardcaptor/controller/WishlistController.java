package com.senac.cardcaptor.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elisa
 */
@RestController
public class WishlistController {
    /*@PostMapping("/adicionarAWishlist/{id}")
    public String adicionarAWishlist(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Photocard photocardSelecionado = null;

        for (Photocard photocard : listaPhotocards) {
            if (photocard.getId().equals(id)) {
                photocardSelecionado = photocard;
                break;
            }
        }

        if (photocardSelecionado != null) {
            listaDesejos.add(photocardSelecionado);
        }

        return "redirect:/wishlist";
    }

    @GetMapping("/wishlist")
    public String exibirWishlist(Model model) {
        model.addAttribute("wishlist", listaDesejos);
        return "wishlist";
    }

    @PostMapping("/removerDaWishlist/{id}")
    public String removerDaWishlist(@PathVariable Integer id) {
        listaDesejos.removeIf(photocard -> photocard.getId().equals(id));
        return "redirect:/wishlist";
    }*/
}
