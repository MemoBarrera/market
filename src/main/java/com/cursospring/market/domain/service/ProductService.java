package com.cursospring.market.domain.service;

import com.cursospring.market.domain.Product;
import com.cursospring.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getById(productId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        if(productRepository.getById(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }
        else {
            return false;
        }

        //Otra forma de hacerlo
        //return productRepository.getProduct(productId).map(product -> {
        //    productRepository.delete(productId);
        //    return true;
        //}).orElse(false);

    }
}
