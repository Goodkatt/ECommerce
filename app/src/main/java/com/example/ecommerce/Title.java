package com.example.ecommerce;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Title implements Serializable {
    private String title;
    private Bitmap direction;

    public Title() {
    }

    public Title(String title, Bitmap direction) {
        this.title = title;
        this.direction = direction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getDirection() {
        return direction;
    }

    public void setDirection(Bitmap direction) {
        this.direction = direction;
    }
}
