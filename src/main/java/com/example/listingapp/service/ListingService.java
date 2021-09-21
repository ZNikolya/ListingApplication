package com.example.listingapp.service;

import com.example.listingapp.model.Listing;

import java.util.List;

public interface ListingService {
    List<Listing> findAll();

    Listing findById(int id);

    Listing addListing(Listing listing);

    List<Listing> findByEmail(String email);

    List<Listing> findByCategory(int categoryId);

    Listing putListing(int id, Listing listing);

    void deleteListing(int id);
}
