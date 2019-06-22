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
    ProductService productServiceImp;

    public void saveProduct(Product product){
        productServiceImp.saveProduct(product);
    }


    public Product getProductById(int id) throws Exception {
            return productServiceImp.getProduct(id);
    }

    public void saveProducts(List<Product> products){
        productServiceImp.saveProducts(products);
    }

    public void deleteProduct(int id) {
        productServiceImp.deleteProduct(id);
    }
}
