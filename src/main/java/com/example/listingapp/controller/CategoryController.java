package com.example.listingapp.controller;

import com.example.listingapp.dto.CategoryCreateDto;
import com.example.listingapp.dto.CategoryDto;
import com.example.listingapp.model.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper mapper;

    @GetMapping("/categories")
    public List<CategoryDto> findAllCategory() {

        List<Category> all = categoryService.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : all) {
            CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
            categoryDtos.add(categoryDto);

        }

        return categoryDtos;
}

    @GetMapping("/categories/{id}")
    public CategoryDto findById(@PathVariable("id") int id) {
        return mapper.map(categoryService.findById(id), CategoryDto.class);    }

    @PostMapping("/categories")
    public CategoryDto addCategory(@RequestBody CategoryCreateDto category) {
        return mapper.map(categoryService.addCategory(mapper.map(category,Category.class)), CategoryDto.class);
    }

    @PutMapping("/categories/{id}")
    public CategoryDto putCategory(@PathVariable int id, @RequestBody String name) {
        return mapper.map(categoryService.putCategory(id,name), CategoryDto.class);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
