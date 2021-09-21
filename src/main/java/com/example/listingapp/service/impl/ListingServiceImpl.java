package com.example.listingapp.service.impl;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {
    private final ListingRepository listingRepository;
    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public Listing findById(int id) {
        return listingRepository.findById(id).get();
    }

    @Override
    public Listing addListing(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public List<Listing> findByEmail(String email) {
        return listingRepository.findAllByUser_Email(email);
    }

    @Override
    public List<Listing> findByCategory(int categoryId) {
        return listingRepository.findAllByCategory_Id(categoryId);
    }

    @Override
    public Listing putListing(int id, Listing listing) {

        Listing byId = listingRepository.findById(id).get();
        byId.setTitle(listing.getTitle());
        byId.setDescription(listing.getDescription());
        byId.setPrice(listing.getPrice());
        byId.setCategory(listing.getCategory());
        byId.setUser(listing.getUser());
        return listingRepository.save(byId);

    }

    @Override
    public void deleteListing(int id) {
        listingRepository.deleteById(id);
    }
}
