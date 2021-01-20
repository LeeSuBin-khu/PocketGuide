package com.lee.pg;

import android.media.Image;

public class Spot {
    private Image image;
    private String name;
    private String location;

    public Spot(Image image, String name, String location) {
        this.image = image;
        this.name = name;
        this.location = location;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
