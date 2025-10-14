package com.example.property.model;


import jakarta.persistence.*;


@Entity
public class Property {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String title;
private String description;
private String address;
private double pricePerMonth;
private int bedrooms;
private String imageUrl; // optional


// Constructors
public Property() {}


public Property(String title, String description, String address, double pricePerMonth, int bedrooms, String imageUrl) {
this.title = title;
this.description = description;
this.address = address;
this.pricePerMonth = pricePerMonth;
this.bedrooms = bedrooms;
this.imageUrl = imageUrl;
}


// Getters & setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public String getAddress() { return address; }
public void setAddress(String address) { this.address = address; }
public double getPricePerMonth() { return pricePerMonth; }
public void setPricePerMonth(double pricePerMonth) { this.pricePerMonth = pricePerMonth; }
public int getBedrooms() { return bedrooms; }
public void setBedrooms(int bedrooms) { this.bedrooms = bedrooms; }
public String getImageUrl() { return imageUrl; }
public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }