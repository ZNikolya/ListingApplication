package com.example.listingapp.controller;

import com.example.listingapp.dto.ListingCreateDto;
import com.example.listingapp.dto.ListingDto;
import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;
    private final ModelMapper mapper;


    @GetMapping("/listings")
    public List<ListingDto> findAllListings(){
        List<Listing> all = listingService.findAll();
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : all) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);

        }

        return listingDtos;
    }

    @GetMapping("/listings/{id}")
    public ListingDto findById(@PathVariable("id") int id){
        return mapper.map(listingService.findById(id), ListingDto.class);
    }

    @GetMapping("/listings/byUser/{email}")
    public List<ListingDto> findByEmail(@PathVariable("email") String email){

        List<Listing> all = listingService.findByEmail(email);
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : all) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);

        }
        return listingDtos;

    }

    @GetMapping("/listings/byCategory/{categoryId}")
    public List<ListingDto> findByCategory(@PathVariable("categoryId") int categoryId){

        List<Listing> all = listingService.findByCategory(categoryId);
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : all) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);

        }
        return listingDtos;
    }

    @PostMapping("/listings")
    public ListingDto addListings(@RequestBody ListingCreateDto listing){
        return mapper.map(listingService.addListing(mapper.map(listing, Listing.class)), ListingDto.class);
    }

    @PutMapping("/listings/{id}")
    public ListingDto putListing(@PathVariable int id , @RequestBody ListingCreateDto listing) {
        return mapper.map(listingService.putListing(id,mapper.map(listing,Listing.class)), ListingDto.class);
    }

    @DeleteMapping("/listings/{id}")
    public void deleteListings(@PathVariable int id) {
        listingService.deleteListing(id);
    }
}
