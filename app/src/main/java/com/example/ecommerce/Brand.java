package com.example.ecommerce;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Brand implements Serializable{
    private String brand;
    private Bitmap brandPic;
    private Bitmap direction;

    public Brand() {
    }

    public Brand(String brand, Bitmap brandPic, Bitmap direction) {
        this.brand = brand;
        this.brandPic = brandPic;
        this.direction = direction;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Bitmap getBrandPic() {
        return brandPic;
    }

    public void setBrandPic(Bitmap brandPic) {
        this.brandPic = brandPic;
    }

    public Bitmap getDirection() {
        return direction;
    }

    public void setDirection(Bitmap direction) {
        this.direction = direction;
    }
}
