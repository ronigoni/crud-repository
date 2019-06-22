package com.radware.exercise.controller;

import com.radware.exercise.models.Product;
import com.radware.exercise.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
@RequestMapping("crud")
public class ProductRestController {

    @Autowired
    ProductController productController;

    @Consumes("application/json")
    @PostMapping(value = "insertProduct")
    public void insetProduct(@RequestBody Product product) {
        productController.saveProduct(product);
    }

    @Consumes("application/json")
    @Produces("application/json")
    @GetMapping(value = "getProduct")
    public Product getProduct(@RequestParam("id") int id) throws Exception {
           return productController.getProductById(id);
    }

    @Consumes("application/json")
    @PutMapping(value = "insertProducts")
    public void createMultipleProducts(@RequestBody Products products) {
         productController.saveProducts(products.getProducts());
    }

    @DeleteMapping(value = "deleteProduct")
    public void delete(@RequestParam("id") int id) {
         productController.deleteProduct(id);
    }
}
