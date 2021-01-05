package org.csu.javaweb.persistence;

import org.csu.javaweb.domain.CartItem;

import java.util.List;

public interface CartDao {
    List<CartItem> getCartItemListByUserId(String UserId);

    void setCartItemList(String UserId, List<CartItem>CartItemList);

    void UpDateCart(String UserId,List<CartItem>CartItemList);
}
