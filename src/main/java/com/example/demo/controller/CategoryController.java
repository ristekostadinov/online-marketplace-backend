package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.requests.CategoryRequest;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> listCategories(){
        return this.categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category showCategory(@PathVariable(value = "id") Long id){
        return this.categoryService.findById(id);
    }

    @PostMapping(value = "")
    public Category createCategory(@RequestBody CategoryRequest categoryRequest){
        return this.categoryService.save(categoryRequest);
    }

    @PutMapping(value = "/{id}")
    public Category editCategory(@PathVariable(value = "id") Long id, @RequestBody String name){
        return this.categoryService.editCategory(id, name);
    }

    @DeleteMapping(value = "/{id}")
    public Category deleteCategory(@PathVariable(value = "id") Long id){
        return this.categoryService.delete(id);
    }
}
