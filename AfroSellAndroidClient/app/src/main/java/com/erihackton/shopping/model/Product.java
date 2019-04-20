package com.erihackton.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.erihackton.shopping.ActivityUtil;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import okhttp3.ResponseBody;

/**
 * Created by aelaf on 2/5/19.
 */

public class Product implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.productId);
        dest.writeString(this.productName);
        dest.writeString(this.productCategory);
        dest.writeString(this.productType);
        dest.writeDouble(this.price);
        dest.writeString(this.productImage);
        dest.writeString(this.productDiscription);
        dest.writeLong(this.dateCreated != null ? this.dateCreated.getTime() : -1);
        dest.writeLong(this.dateDeleted != null ? this.dateDeleted.getTime() : -1);
    }

    protected Product(Parcel in) {
        this.productId = in.readInt();
        this.productName = in.readString();
        this.productCategory = in.readString();
        this.productType = in.readString();
        this.price = in.readDouble();
        this.productImage = in.readString();
        this.productDiscription = in.readString();
        long tmpDateCreated = in.readLong();
        this.dateCreated = tmpDateCreated == -1 ? null : new Date(tmpDateCreated);
        long tmpDateDeleted = in.readLong();
        this.dateDeleted = tmpDateDeleted == -1 ? null : new Date(tmpDateDeleted);
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
