package com.avishkar.recyclerviewdemo.model;

import android.widget.ArrayAdapter;

public class ItemsModel {
    int image;
    String title,description,price;

    public ItemsModel(int img, String title, String description, String price) {
        this.image = img;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
