package com.sandydalvi.agroapp;

public class GoiDetail {

    private String GroceryName,GroceryPlace,GroceryPrice,GroceryTime;

    public GoiDetail()
    {}

    public GoiDetail(String groceryName, String groceryPlace, String groceryPrice, String GroceryTime) {
        GroceryName = groceryName;
        GroceryPlace = groceryPlace;
        GroceryPrice = groceryPrice;
        //GroceryTime = GroceryTime;
    }

    public String getGroceryName() {
        return GroceryName;
    }

    public void setGroceryName(String groceryName) {
        GroceryName = groceryName;
    }

    public String getGroceryPlace() {
        return GroceryPlace;
    }

    public void setGroceryPlace(String groceryPlace) {
        GroceryPlace = groceryPlace;
    }

    public String getGroceryPrice() {
        return GroceryPrice;
    }

    public void setGroceryPrice(String groceryPrice) {
        GroceryPrice = groceryPrice;
    }

//    public String getGroceryTime() {
//        return GroceryTime;
//    }
//
//    public void setGroceryTime(Long groceryTime) {
//        GroceryTime = GroceryTime;
//    }
}
