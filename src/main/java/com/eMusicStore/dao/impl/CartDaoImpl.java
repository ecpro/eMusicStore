package com.eMusicStore.dao.impl;

import com.eMusicStore.dao.CartDao;
import com.eMusicStore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao{

    public Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {

        if(listOfCarts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create this cart. " +
                    "A cart with the given cartId %s already exists.",cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {

        //if(!listOfCarts.containsKey(cartId)) throw new IllegalArgumentException(String.format("The given cart with cartId %s" +
          //      "does not exists",cartId));

        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {

        if(!listOfCarts.containsKey(cartId)) throw new IllegalArgumentException(String.format("The cart with given cartId %s " +
                "does not exists", cartId));

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {

        if(!listOfCarts.containsKey(cartId)) throw new IllegalArgumentException(String.format("Cart with Id %s does not " +
                "exists",cartId));

        listOfCarts.remove(cartId);

    }
}
