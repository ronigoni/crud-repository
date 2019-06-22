package com.radware.exercise.service;

import com.radware.exercise.models.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    Product getProduct(int id) throws Exception;

    void saveProducts(List<Product> products);

    void deleteProduct(int id);
}
