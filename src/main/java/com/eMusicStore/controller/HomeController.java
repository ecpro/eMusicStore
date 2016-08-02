package com.eMusicStore.controller;

import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by PIYUSH on 01-07-2016.
 */

@Controller
public class HomeController {

    @Autowired
    @Qualifier("productDaoImpl")
    private ProductDao productDao;


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/products/productList", method = RequestMethod.GET)
    public String getProducts(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/viewProducts/{productId}")
    public String getProductDetails(@PathVariable String productId, Model model) {
        Product product = productDao.getProductById(productId);

        model.addAttribute("product", product);

        return "viewProducts";

    }

}
