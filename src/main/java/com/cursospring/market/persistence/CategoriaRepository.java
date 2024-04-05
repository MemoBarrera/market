package com.cursospring.market.persistence;

import com.cursospring.market.domain.Category;
import com.cursospring.market.domain.repository.CategoryRepository;
import com.cursospring.market.persistence.crud.CategoriaCRUDRepository;
import com.cursospring.market.persistence.entity.Categoria;
import com.cursospring.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoriaCRUDRepository categoriaCRUDRepository;
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getByStatus() {
        List<Categoria> categorias = categoriaCRUDRepository.findByEstado(true);
        return mapper.toCategories(categorias);
    }

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCRUDRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getById(int id) {
        return categoriaCRUDRepository.findById(id).map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCRUDRepository.save(categoria));
    }

    @Override
    public void delete(int id) {
        categoriaCRUDRepository.deleteById(id);
    }
}
