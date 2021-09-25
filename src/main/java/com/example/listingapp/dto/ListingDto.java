package com.example.listingapp.dto;


import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListingDto {

    private int id;
    private String title;
    private String description;
    private int price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
