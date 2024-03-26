package com.cursospring.market.persistence;

import com.cursospring.market.domain.Product;
import com.cursospring.market.domain.repository.ProductRepository;
import com.cursospring.market.persistence.crud.ProductoCRUDRepository;
import com.cursospring.market.persistence.entity.Producto;
import com.cursospring.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCRUDRepository productoCRUDRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCRUDRepository.findAll();
        return mapper.toProducts(productos);
    };

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId){
        return productoCRUDRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCRUDRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCRUDRepository.deleteById(productId);
    }
}
