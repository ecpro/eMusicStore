package com.eMusicStore.dao.impl;

import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(String id) {

        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    public List<Product> getAllProducts() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public boolean deleteProduct(String id) {

        Session session = sessionFactory.getCurrentSession();
        Product product = getProductById(id);
        session.delete(product);
        session.flush();
        return true;
    }

    public boolean editProduct(Product product) {


        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

        return true;
    }
}
