package com.cursospring.market.persistence.crud;

import com.cursospring.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaCRUDRepository extends CrudRepository<Categoria,Integer> {
    List<Categoria> findByEstado(boolean estado);
}
