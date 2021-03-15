package com.example.ecommerce;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Category implements Serializable {

    private String categoryName;
    private String categorySubtitle;
    private Bitmap categoryImage;

    public Category() {
    }

    public Category(String categoryName, String categorySubtitle, Bitmap categoryImage) {
        this.categoryName = categoryName;
        this.categorySubtitle = categorySubtitle;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Bitmap getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Bitmap categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategorySubtitle() {
        return categorySubtitle;
    }

    public void setCategorySubtitle(String categorySubtitle) {
        this.categorySubtitle = categorySubtitle;
    }
}
