package com.example.listingapp.repository;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
