package com.erihackton.shopping.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aelaf on 2/7/19.
 */

public class AfroSellLocalDataSource implements DataSource{
    public static final String TAG ="AfroSellLocalData";
    Context mContext;
    public static AfroSellLocalDataSource afroSellLocalDataSource;
    private  AfroSellDbHelper afroSellDbHelper ;

    public static  AfroSellLocalDataSource getINSTANCE(Context context){
        if(afroSellLocalDataSource==null)
            afroSellLocalDataSource = new AfroSellLocalDataSource(context);
        return afroSellLocalDataSource;
    }

    private AfroSellLocalDataSource(Context context) {
      afroSellDbHelper = new AfroSellDbHelper(context);

    }

    @Override
    public void getAuthenticUser(String name, String password, getAuthenticUserCallBack getAuthenticUserCallBack) {

    }

    @Override
    public void getAllProducts(GetAllProductsCallBack getAllProductsCallBack) {
        SQLiteDatabase db = afroSellDbHelper.getReadableDatabase();
       Cursor c =  db.rawQuery("SELECT * FROM "+ AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME,null);
        List<Product> productList = new ArrayList<>();

        while(c.moveToNext()){
            String productName = c.getString(c.getColumnIndexOrThrow("product_name"));
            double productPrice = c.getDouble(c.getColumnIndexOrThrow("product_price"));

            Product product = new Product(productName,productPrice);
            product.setProductId(c.getInt(c.getColumnIndexOrThrow("product_id")));
            product.setProductCategory(c.getString(c.getColumnIndexOrThrow("product_category")));
            product.setProductType(c.getString(c.getColumnIndexOrThrow("product_type")));
            product.setProductDiscription(c.getString(c.getColumnIndexOrThrow("product_description")));
            product.setProductImage(c.getString(c.getColumnIndexOrThrow("product_image")));
            product.setDateCreated(null);
            product.setDateDeleted(null);
        //IDIOTA!!!
            productList.add(product);

        }
        if(!productList.isEmpty())
            getAllProductsCallBack.onSuccess(productList);
        else
            getAllProductsCallBack.onError("can not retrieve Products from local DB");
        if(c!=null)
            c.close();
        db.close();

    }

    @Override
    public void getProduct(int id, GetProductCallBack getProductCallBack) {

    }

    @Override
    public void addProduct(Product pro, AddProductCallBack addProductCallBack) {
    SQLiteDatabase db = afroSellDbHelper.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_NAME,pro.getProductName());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_PRICE,pro.getPrice());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_CATEGORY,pro.getProductCategory());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID,pro.getProductId());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_IMAGE,pro.getProductImage());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_TYPE,pro.getProductType());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DESCRIPTION,pro.getProductDiscription());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_CREATED, new Date().toString());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_DELETED,new Date().toString());

       long result =  db.insert(AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME,null,cn);
        cn.clear();
        addProductCallBack.onSuccess("hopefully added into local DB... "+result);


        db.close();
    }

    @Override
    public void updateProduct(Product pro, UpdateProductCallBack updateProductCallBack) {

        SQLiteDatabase db = afroSellDbHelper.getWritableDatabase();

        ContentValues cn = new ContentValues();
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_NAME,pro.getProductName());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_PRICE,pro.getPrice());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_CATEGORY,pro.getProductCategory());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID,pro.getProductId());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_IMAGE,pro.getProductImage());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_TYPE,pro.getProductType());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DESCRIPTION,pro.getProductDiscription());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_CREATED, new Date().toString());
        cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_DELETED,new Date().toString());
//"id = ?", new String[] {"1"}
     long result =   db.update(AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME,cn,
                AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID+" = ?",new String[]{pro.getProductId()+""});

        if( result != -1){
            updateProductCallBack.onSuccess("success from db");
        }
        else
            updateProductCallBack.onError("Fail from db");
        cn.clear();
        db.close();
    }

    @Override
    public void deleteProduct(int id, DeleteProductCallBack deleteProductCallBack) {

        SQLiteDatabase db = afroSellDbHelper.getWritableDatabase();
       long result = db.delete(AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME,
                AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID+" = ?",
                new String[]{id+""});
        if (result != -1)
            deleteProductCallBack.onSuccess("success from Db");
        else
            deleteProductCallBack.onError("Fail Deleting from Db");

        db.close();
    }

    @Override
    public void addProducts(List<Product> productList, AddProductsCallBack addProductsCallBack) {
        Log.d(TAG, "addProducts: ");
        /**
         * TODO
         * batch updating sqlite with auto-increment issue
         */
        SQLiteDatabase db = afroSellDbHelper.getWritableDatabase();
        for (Product pro:
             productList) {
            ContentValues cn = new ContentValues();
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_NAME,pro.getProductName());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_PRICE,pro.getPrice());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_CATEGORY,pro.getProductCategory());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID,pro.getProductId());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_IMAGE,pro.getProductImage());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_TYPE,pro.getProductType());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DESCRIPTION,pro.getProductDiscription());
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_CREATED, String.valueOf(pro.getDateCreated()));
            cn.put(AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_DELETED, String.valueOf(pro.getDateDeleted()));

           long result = db.insertWithOnConflict(AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME,null,cn,SQLiteDatabase.CONFLICT_REPLACE);
            cn.clear();
            if (result==-1) {
                addProductsCallBack.onError("failed Updating sqlite");
                return;
            }
        }
        addProductsCallBack.onSuccess("sucessfully updated sqlite");


        db.close();
    }
}
