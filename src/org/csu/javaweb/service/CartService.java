package org.csu.javaweb.service;

import org.csu.javaweb.domain.Cart;
import org.csu.javaweb.domain.CartItem;
import org.csu.javaweb.persistence.CartDao;
import org.csu.javaweb.persistence.impl.CartDaoImpl;

import java.util.List;

public class CartService {
    private CartDao cartDao=new CartDaoImpl();

    public Cart getCartByUserId(String UserId){
        Cart cart=new Cart();
        getCartItemListByUserId(UserId);

        return cart;
    }
    public List<CartItem> getCartItemListByUserId(String UserId) {
        return cartDao.getCartItemListByUserId(UserId);
    }

    public void setCartItemList(String UserId, List<CartItem> CartItemList) {
        cartDao.setCartItemList(UserId,CartItemList);
    }

    public void UpDateCart(String UserId, List<CartItem> CartItemList){
        cartDao.UpDateCart(UserId,CartItemList);
    }

}
