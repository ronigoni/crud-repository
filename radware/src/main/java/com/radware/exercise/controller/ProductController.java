package com.radware.exercise.controller;

import com.radware.exercise.models.Product;
import com.radware.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    public void saveProduct(Product product){
        productService.saveProduct(product);
    }

    public Product getProductById(int id) throws Exception {
            return productService.getProduct(id);
    }

    public void saveProducts(List<Product> products){
        productService.saveProducts(products);
    }

    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }
}
