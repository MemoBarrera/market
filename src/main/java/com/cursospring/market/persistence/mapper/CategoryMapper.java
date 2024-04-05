package com.cursospring.market.persistence.mapper;

import com.cursospring.market.domain.Category;
import com.cursospring.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active")
    })
    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);
    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}
