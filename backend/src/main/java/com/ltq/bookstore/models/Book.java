package com.ltq.bookstore.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Book domain modal.
@Document(collection = "books")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class Book {
    @Id
    private String id;

    @NotBlank
    @Size(max = 100)

    private String title;

    private String imageSrc;

    private String author;

    private float price;

    private float rating;

    private Date createdAt = new Date();

    public Book() {
        super();
    }

    public Book(String title, String imageSrc, String author, float price, float rating) {
        this.title = title;
        this.imageSrc = imageSrc;
        this.author = author;
        this.price = price;
        this.rating = rating;
    }

    // ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Image Source
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    // Author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Price
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Rating
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    // Create At
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}