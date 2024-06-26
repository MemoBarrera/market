package com.cursospring.market.web.controller;

import com.cursospring.market.domain.Category;
import com.cursospring.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId)
                .map(category -> new ResponseEntity<>(category,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Category>> getActiveCategories(){
        return new ResponseEntity<>(categoryService.getByStatus(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int categoryId){
        if(categoryService.delete(categoryId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}