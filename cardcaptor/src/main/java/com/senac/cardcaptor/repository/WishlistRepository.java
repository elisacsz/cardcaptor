package com.senac.cardcaptor.repository;

import com.senac.cardcaptor.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elisa
 */
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

}
