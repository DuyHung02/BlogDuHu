package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    public List<Category> getAll() {
        return (List<Category>) iCategoryRepository.findAll();
    }

    public Category findById(long id) {
        return iCategoryRepository.findById(id).get();
    }
}
