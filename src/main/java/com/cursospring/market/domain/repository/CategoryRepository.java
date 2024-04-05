package com.cursospring.market.domain.repository;

import com.cursospring.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends GeneralRepository<Category>{
    List<Category> getByStatus();
}
