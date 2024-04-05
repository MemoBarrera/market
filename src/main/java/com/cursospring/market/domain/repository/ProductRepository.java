package com.cursospring.market.domain.repository;

import com.cursospring.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends GeneralRepository<Product>{
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);

}
