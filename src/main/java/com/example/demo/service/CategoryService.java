package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.exception.CategoryNotFoundException;
import com.example.demo.model.requests.CategoryRequest;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id){
        return this.categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("The category id doesn't exist in the database"));
    }

    @Transactional
    public Category save(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    @Transactional
    public Category editCategory(Long id, String name){
        Category category = this.findById(id);
        category.setName(name);
        return this.categoryRepository.save(category);
    }

    @Transactional
    public Category delete(Long id){
        Category category = this.findById(id);
        this.categoryRepository.delete(category);
        return category;
    }
}
