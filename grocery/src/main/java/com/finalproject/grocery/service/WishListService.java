package com.finalproject.grocery.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.finalproject.grocery.entity.WishList;
import com.finalproject.grocery.repository.WishListRepository;


@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(Integer userId) {
        return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
    }
}
