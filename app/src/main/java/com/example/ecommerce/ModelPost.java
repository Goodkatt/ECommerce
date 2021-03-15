package com.example.ecommerce;

import android.graphics.Bitmap;

import java.io.Serializable;

public class ModelPost implements Serializable {
    private String category;
    private String title;
    private String brand;
    private String productName;
    private String price;
    private String detail;
    private String addDate;

    public ModelPost() {
    }

    public ModelPost(String category, String title, String brand, String productName, String price, String detail, String addDate) {
        this.category = category;
        this.title = title;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.detail = detail;
        this.addDate = addDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
