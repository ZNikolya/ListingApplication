package com.example.listingapp.controller;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;
    @GetMapping("/listings")
    public List<Listing> findAllCategory(){
        return listingService.findAll();
    }

    @GetMapping("/listings/{id}")
    public Listing findById(@PathVariable("id") int id){
        return listingService.findById(id);
    }

    @GetMapping("/listings/byUser/{email}")
    public List<Listing> findByEmail(@PathVariable("email") String email){
        return listingService.findByEmail(email);
    }
    @GetMapping("/listings/byCategory/{categoryId}")
    public List<Listing> findByCategory(@PathVariable("categoryId") int categoryId){
        return listingService.findByCategory(categoryId);
    }
    @PostMapping("/listings")
    public Listing addCategory(@RequestBody Listing listing){
        return listingService.addListing(listing);
    }
    @PutMapping("/listings/{id}")
    public Listing putListing(@PathVariable int id , @RequestBody Listing listing) {
        return listingService.putListing(id, listing);
    }
    @DeleteMapping("/listings/{id}")
    public void deletelisting(@PathVariable int id) {
        listingService.deleteListing(id);
    }
}
