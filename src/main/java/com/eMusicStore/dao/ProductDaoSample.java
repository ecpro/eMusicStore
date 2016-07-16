package com.eMusicStore.dao;

import com.eMusicStore.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PIYUSH on 01-07-2016.
 */
public class ProductDaoSample {

    List<Product> productList;

    public List<Product> getProductList() {

        Product product = new Product();
        product.setProductId("pd123");
        product.setProductCategory("String Instrument");
        product.setProductCondition("New");
        product.setProductDescription("Bass guitar");
        product.setProductManufacturer("Yamaha");
        product.setProductName("Guitar");
        product.setProductStatus("Active");
        product.setUnitInStock(11);
        product.setProductPrice(100);

        Product product1 = new Product();
        product1.setProductId("pd35");
        product1.setProductCategory("Song Album");
        product1.setProductCondition("New");
        product1.setProductDescription("Latest Album 2015");
        product1.setProductManufacturer("Sony Music");
        product1.setProductName("Living Things");
        product1.setProductStatus("Active");
        product1.setUnitInStock(23);
        product1.setProductPrice(47);

        Product product2 = new Product();
        product2.setProductId("pd315");
        product2.setProductCategory("Wind Instrument");
        product2.setProductCondition("Old");
        product2.setProductDescription("C# notes Flute");
        product2.setProductManufacturer("Poona Flutes");
        product2.setProductName("Flute");
        product2.setProductStatus("Active");
        product2.setUnitInStock(2);
        product2.setProductPrice(30);

        productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);

        return productList;
    }

    public Product getProductById(String id) {
        for(Product curr : getProductList()) {
            if(curr.getProductId().equals(id)) {
                return curr;
            }
        }
        throw new NullPointerException("Product with product ID " + id + "not found");
    }
}
