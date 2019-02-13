package com.erihackton.shopping.source;

import android.content.Context;
import android.util.Log;

import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.local.AfroSellLocalDataSource;
import com.erihackton.shopping.source.remote.AfroSellRemoteDataSource;

import java.util.List;

/**
 * Created by aelaf on 2/5/19.
 */

public class DataSourceRepository implements DataSource {
public static final String TAG = "DataSource";
    static DataSourceRepository dataSourceRepository;
    private static AfroSellRemoteDataSource afroSellRemoteDataSource;
    private static AfroSellLocalDataSource afroSellLocalDataSource;

    public static DataSourceRepository getInstance(Context context){
        if(dataSourceRepository==null)
            dataSourceRepository = new DataSourceRepository(context);
        return dataSourceRepository;
    }

    private DataSourceRepository(Context context) {
        afroSellRemoteDataSource = AfroSellRemoteDataSource.getINSTANCE();
        afroSellLocalDataSource = AfroSellLocalDataSource.getINSTANCE(context);
    }

    @Override
    public void getAuthenticUser(String name, String password, getAuthenticUserCallBack getAuthenticUserCallBack) {

    }

    @Override
    public void getAllProducts(final GetAllProductsCallBack getAllProductsCallBack) {
        //CHECK INTO LOCAL...
        afroSellLocalDataSource.getAllProducts(new GetAllProductsCallBack() {
            @Override
            public void onSuccess(List<Product> productList) {
                //no need for n/w call
                Log.d(TAG, "onSuccess: d/b "+productList.size());
                getAllProductsCallBack.onSuccess(productList);
                /**
                 * TODO
                 * FUTURE FEATURE
                 * CHECK FOR  CONNECTION AND REQUEST FOR UPDATE
                 */
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: db.. "+err);
                //need for n/w call
                afroSellRemoteDataSource.getAllProducts(new GetAllProductsCallBack() {
                    @Override
                    public void onSuccess(final List<Product> productList) {
                        Log.d(TAG, "onSuccess: n/w");
                        //adding into sqlite
                        afroSellLocalDataSource.addProducts(productList, new AddProductsCallBack() {
                            @Override
                            public void onSuccess(String result) {
                                Log.d(TAG, "onSuccess: adding list of products  to sqlite "+result);
                                getAllProductsCallBack.onSuccess(productList);
                            }

                            @Override
                            public void onError(String err) {
                                Log.d(TAG, "onError:can not add fetched data to sqlite "+err);
                                getAllProductsCallBack.onError(err);
                            }
                        });
                    }

                    @Override
                    public void onError(String err) {
                        Log.d(TAG, "onError: n/w");
                        getAllProductsCallBack.onError(err);
                    }
                });
            }
        });
       
    }

    @Override
    public void getProduct(int id, GetProductCallBack getProductCallBack) {

    }

    @Override
    public void addProduct(final Product pro, final AddProductCallBack addProductCallBack) {
        afroSellRemoteDataSource.addProduct(pro, new AddProductCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess:on n/w "+result);
               // addProductCallBack.onSuccess(result);
                //then add into local
                afroSellLocalDataSource.addProduct(pro, new AddProductCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        Log.d(TAG, "onSuccess: on n/w "+result);
                        addProductCallBack.onSuccess(result);
                    }

                    @Override
                    public void onError(String err) {
                        Log.d(TAG, "onError: on db "+err); 
                        addProductCallBack.onError(err);
                    }
                });
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: n/w"+err);
                addProductCallBack.onError(err);
            }
        });

    }

    @Override
    public void updateProduct(Product pro, int id, UpdateProductCallBack updateProductCallBack) {

    }

    @Override
    public void deleteProduct(int id, DeleteProductCallBack deleteProductCallBack) {

    }

    @Override
    public void addProducts(List<Product> product, AddProductsCallBack addProductsCallBack) {

    }
}
