package com.radware.exercise.service;

import com.radware.exercise.RadWareApplication;
import com.radware.exercise.models.Product;
import com.radware.exercise.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository repository;

    private static final Logger logger = LogManager.getLogger(RadWareApplication.class);

    public void saveProduct(Product product){
        logger.info("saving product with id " + product.getId());
        repository.save(product);
    }

    public Product getProduct(int id) throws Exception {
        Optional<Product> product = repository.findById(id);
        if(!product.isPresent()) {
            logger.info("Product with id " + id + " not found");
            throw new Exception("Product with id " + id + " not found");
        }
        return product.get();
    }

    public void saveProducts(List<Product> products) {
        List<Integer> ids = products.stream().map(Product::getId).collect(Collectors.toList());
        logger.info("saving products with id's " + ids.toString() );
        repository.saveAll(products);
    }

    public void deleteProduct(int id) {
        logger.info("delete product with id " + id);
        repository.deleteById(id);
    }
}
