package com.example.listproduct;

public class Product {
    String productName, stock, price;
    int imageId;


    public Product(String productName, String stock, String price, int imageId) {
        this.productName = productName;
        this.stock = stock;
        this.imageId = imageId;
        this.price = price;
    }
}
