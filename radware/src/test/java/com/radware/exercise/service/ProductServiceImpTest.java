package com.radware.exercise.service;

import com.radware.exercise.models.Aspect;
import com.radware.exercise.models.Product;
import com.radware.exercise.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImpTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImp productService;

    Product product = new Product();

    @Before
    public void setUp(){
        product.setId(5);
        product.setName("name");
        product.setCategory("12345");
        List<Aspect> aspects = new ArrayList<>();
        Aspect aspect = new Aspect("name","value");
        aspects.add(aspect);
        product.setAspects(aspects);
    }

    @Test
    public void givenProductTheRepositorySaveProduct(){
        productService.saveProduct(product);
        verify(repository,times(1)).save(product);
    }

    @Test
    public void givenProductIdTheRepositorygetProduct() throws Exception {
        when(repository.getOne(1)).thenReturn(product);
        Product product = productService.getProduct(1);
        verify(repository,times(1)).getOne(1);
        assertEquals(product.getId(),5);
    }

    @Test
    public void givenProductsTheRepositorySaveProducts(){
        List<Product> products = new ArrayList<>();
        productService.saveProducts(products);
        verify(repository,times(1)).saveAll(products);
    }

    @Test
    public void givenProductIdTheRepositorydeleteProduct(){
        productService.deleteProduct(1);
        verify(repository,times(1)).deleteById(1);
    }

}