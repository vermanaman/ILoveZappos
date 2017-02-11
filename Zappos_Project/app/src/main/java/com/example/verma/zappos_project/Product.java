package com.example.verma.zappos_project;

import java.io.Serializable;

/**
 * Created by verma on 1/31/2017.
 */
public class Product implements Serializable{

    String brandeName;
    String imageURL;
    String orginalPrice;
    String productID;
    String styleID;
    String colorID;
    String productName;
    String price;
    String discount;
    String productURL;

    public String getBrandeName() {
        return brandeName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getStyleID() {
        return styleID;
    }

    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public String getColorID() {
        return colorID;
    }

    public void setColorID(String colorID) {
        this.colorID = colorID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrandeName(String brandeName) {
        this.brandeName = brandeName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getOrginalPrice() {
        return orginalPrice;
    }

    public void setOrginalPrice(String orginalPrice) {
        this.orginalPrice = orginalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    @Override
    public String toString() {
        return brandeName +"+"+imageURL+"+"+orginalPrice+"+"+ productID+"+"+styleID+"+"+colorID+"+"+productName+"+"+price+"+"+discount+"+"+productURL;
    }
}
