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
 * Created by eccspro on 24/07/16.
 */

@Controller
public class AdminController {


    @Autowired
    @Qualifier("productDaoImpl")
    private ProductDao productDao;

    private Path path;


    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> allProducts = productDao.getAllProducts();
        model.addAttribute("products", allProducts);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");
        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, HttpServletRequest request) {

        if(bindingResult.hasErrors()) {
            return "addProduct";
        }

        System.out.println(product);
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + product.getProductId() +".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed");
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") String id, HttpServletRequest request) {
        productDao.deleteProduct(id);

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id +".png");

        deleteImages(path);

        return "redirect:/admin/productInventory";
    }

    private static void deleteImages(Path path) {
        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to delete the image");
            }
        }
    }

    @RequestMapping("/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        Product product = productDao.getProductById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product,  BindingResult result,HttpServletRequest request) {
        if(result.hasErrors()) {
            return "editProduct";
        }

        productDao.editProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");


        if(productImage != null && !productImage.isEmpty() ) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to update the product image");

            }
        }

        return "redirect:/admin/productInventory";


    }

}
