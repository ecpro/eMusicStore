package com.eMusicStore.controller;

import com.eMusicStore.dao.CartDao;
import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Cart;
import com.eMusicStore.model.CartItem;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * Created by eccspro on 27/07/16.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    private PrintWriter out = new PrintWriter(System.out);

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable("cartId") String cartId) {
        return cartDao.read(cartId);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("cartId") String cartId, @RequestBody Cart cart) {
        cartDao.update(cartId, cart);
    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("cartId")String cartId) {
        cartDao.delete(cartId);
    }

    @RequestMapping(value="/add/{productId}", method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable("productId")String productId, HttpServletRequest request) {

        String cartId = request.getSession(true).getId();
        Cart cart = cartDao.read(cartId);

        if(cart == null) cart = cartDao.create(new Cart(cartId));
        Product product = productDao.getProductById(productId);

        if(product == null) throw new IllegalArgumentException("The entered product doesn't exists");

        cart.addCartItem(new CartItem(product));

        cartDao.update(cartId,cart);

    }


    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value="productId")String productId, HttpServletRequest request) {
        String cartId = request.getSession(true).getId();
        Cart cart = cartDao.read(cartId);

        if(cart == null) cart = cartDao.create(new Cart(cartId));

        Product product = productDao.getProductById(productId);
        if(product == null) throw new IllegalArgumentException("The entered product doesn't exists");

        cart.removeCartItem(new CartItem(product));

        cartDao.update(cartId,cart);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "please verify your payload")
    public void handleClientError() {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="internal server error")
    public void handleInternalServerError(Exception e) {
        e.printStackTrace(out);
    }


}
