package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    List<Listing> findAllByUser_Email(String email);
    List<Listing> findAllByCategory_Id(int categoryId);
}
