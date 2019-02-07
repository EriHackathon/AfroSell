package com.erihackton.shopping.source.remote;

import android.util.Log;

import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aelaf on 2/6/19.
 */

public class AfroSellRemoteDataSource implements DataSource {
    public static final String TAG = "AfroSellRemote";
    public static final String baseUrl = "http://192.168.43.114:8000";
    private static Retrofit retrofit = null;
    public static AfroSellRemoteDataSource INSTANCE;
    private  AfroAPIInterface afroAPIInterface ;

    private static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    public static AfroSellRemoteDataSource getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE = new AfroSellRemoteDataSource();
        return INSTANCE;
    }
    private AfroSellRemoteDataSource(){
         afroAPIInterface =  getClient().create(AfroAPIInterface.class);

    }
    @Override
    public void getAuthenticUser(String name, String password, getAuthenticUserCallBack getAuthenticUserCallBack) {

    }

    @Override
    public void getAllProducts(final GetAllProductsCallBack getAllProductsCallBack) {
      Call<List<Product>>productListResult =  afroAPIInterface.getAllProducts();
        productListResult.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
              List<Product> productList =  response.body();
                getAllProductsCallBack.onSuccess(productList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable throwable) {
                getAllProductsCallBack.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getProduct(int id, GetProductCallBack getProductCallBack) {

    }

    @Override
    public void addProduct(Product pro, final AddProductCallBack addProductCallBack) {
    final Call<String> productCall =  afroAPIInterface.addProduct(pro);
       productCall.enqueue(new Callback<String>() {
           @Override
           public void onResponse(Call<String> call, Response<String> response) {
               Log.d(TAG, "onSuccess"+response.body());
               addProductCallBack.onSuccess(response.body()+"added to n/w");
           }

           @Override
           public void onFailure(Call<String> call, Throwable throwable) {
               Log.d(TAG, "onFailure: "+throwable.getMessage());
                addProductCallBack.onError(throwable.getMessage()+"can't add to n/w");
           }
       });
    }

    @Override
    public void updateProduct(Product pro, int id, UpdateProductCallBack updateProductCallBack) {

    }

    @Override
    public void deleteProduct(int id, DeleteProductCallBack deleteProductCallBack) {

    }
}
