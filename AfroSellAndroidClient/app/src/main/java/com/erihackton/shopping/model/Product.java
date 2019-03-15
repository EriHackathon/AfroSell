package com.erihackton.shopping.model;

import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.erihackton.shopping.ActivityUtil;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by aelaf on 2/5/19.
 */

public class Product {

    private int productId;
    private String productName;
    private String productCategory;
    private String  productType ;

    private double price;
    private String productImage;
    private String productDiscription;
    @Nullable
    private Date dateCreated,dateDeleted;
 //   private Rank mRank;


    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

   /* public Rank getmRank() {
        return mRank;
    }

    public void setmRank(Rank mRank) {
        this.mRank = mRank;
    }*/
}
