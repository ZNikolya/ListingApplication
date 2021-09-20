package com.example.listingapp.service;

import com.example.listingapp.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category addCategory(Category category);
    Category putCategory(int id, String name);
    void
    deleteCategory(int id);
}
