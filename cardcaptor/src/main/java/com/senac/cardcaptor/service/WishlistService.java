package com.senac.cardcaptor.service;

import com.senac.cardcaptor.model.Photocard;
import com.senac.cardcaptor.model.Wishlist;
import com.senac.cardcaptor.repository.WishlistRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elisa
 */
@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    private Wishlist wishlist; 

    @PostConstruct
    public void init() {
        if (wishlistRepository.count() == 0) {
            wishlist = new Wishlist();
            wishlistRepository.save(wishlist);
        } else {
            wishlist = wishlistRepository.findAll().get(0);
        }
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void adicionarPhotocardWishlist(Photocard photocard) {
        if (!wishlist.getPhotocards().contains(photocard)) {
            wishlist.getPhotocards().add(photocard);
            wishlistRepository.save(wishlist);
        }
    }

    public void removerPhotocardWishlist(Photocard photocard) {
        wishlist.getPhotocards().remove(photocard);
        wishlistRepository.save(wishlist);
    }

    public List<Photocard> listarPhotocardsWishlist() {
        return wishlist.getPhotocards();
    }
}