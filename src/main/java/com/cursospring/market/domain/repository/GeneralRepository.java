package com.cursospring.market.domain.repository;

import com.cursospring.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface GeneralRepository<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    T save(T t);
    void delete(int id);
}
