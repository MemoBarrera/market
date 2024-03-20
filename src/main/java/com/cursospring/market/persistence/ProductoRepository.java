package com.cursospring.market.persistence;

import com.cursospring.market.persistence.crud.ProductoCRUDRepository;
import com.cursospring.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getALl(){
        return (List<Producto>) productoCRUDRepository.findAll();
    };

    public List<Producto> getByCategoria(Integer idCategoria){
        return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getByStockTrue(int cantidad){
        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getById(int id){
        return productoCRUDRepository.findById(id);
    }

    public Producto save(Producto producto){
        return productoCRUDRepository.save(producto);
    }

    public void delete(int id){
        productoCRUDRepository.deleteById(id);
    }
}
