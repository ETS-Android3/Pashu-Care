package com.sandydalvi.agroapp.Types;

import java.io.Serializable;
import java.util.ArrayList;

public class Categories{

    private int imageResource;
    private String title;

    public Categories(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;

    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //    public Categories()
//    {
//
//    }
//
//    public Categories(int imageResource, String title) {
//        this.imageResource = imageResource;
//        this.title = title;
//    }
//
//    public int getImageResource() {
//        return imageResource;
//    }
//
//    public void setImageResource(int imageResource) {
//        this.imageResource = imageResource;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

}
