package com.eMusicStore.dao;

import com.eMusicStore.model.Product;

import java.util.List;

/**
 * Created by PIYUSH on 03-07-2016.
 */
public interface ProductDao {

    public void addProduct(Product product) ;

    public Product getProductById(String id);

    public List<Product> getAllProducts();

    public boolean deleteProduct(String id);

    public boolean editProduct(Product product);
}
