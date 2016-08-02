package com.eMusicStore.dao;
import com.eMusicStore.model.Cart;
/**
 * Created by eccspro on 25/07/16.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
