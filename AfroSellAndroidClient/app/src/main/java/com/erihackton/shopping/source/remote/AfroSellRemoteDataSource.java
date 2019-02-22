package com.erihackton.shopping.source.remote;

import android.util.Log;

import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    public static final String baseUrl = "http://192.168.43.114:3300";
    private static Retrofit retrofit = null;
    public static AfroSellRemoteDataSource INSTANCE;
    private AfroAPIInterface afroAPIInterface;

    private static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit;
    }

    public static AfroSellRemoteDataSource getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AfroSellRemoteDataSource();
        return INSTANCE;
    }

    private AfroSellRemoteDataSource() {
        afroAPIInterface = getClient().create(AfroAPIInterface.class);

    }

    @Override
    public void getAuthenticUser(String name, String password, getAuthenticUserCallBack getAuthenticUserCallBack) {

    }

    @Override
    public void getAllProducts(final GetAllProductsCallBack getAllProductsCallBack) {
        Call<List<Product>> productListResult = afroAPIInterface.getAllProducts();
        productListResult.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> productList = response.body();
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
        final Call<Void> productCall = afroAPIInterface.addProduct(pro);
        productCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onSuccess" + response.body());
                Log.d(TAG, "onResponse: " + call.toString());
                addProductCallBack.onSuccess(response.body() + "added to n/w");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                addProductCallBack.onError(throwable.getMessage() + "can't add to n/w");
            }
        });
      /* productCall.enqueue(new Callback<String>() {
           @Override
           public void onResponse(Call<String> call, Response<String> response) {

           }

           @Override
           public void onFailure(Call<String> call, Throwable throwable) {
               Log.d(TAG, "onFailure: "+throwable.getMessage());
               *//**
         * TODO
         * ADDING WORKS BUT FAILURE MESSAGE
         * End of input at line 1 column 1 path $
         *//*

           }
       });*/
    }

    @Override
    public void updateProduct(final Product pro, final UpdateProductCallBack updateProductCallBack) {
        Log.d(TAG, "updateProduct**: " + pro.getProductId());
        final Call<Void> productUpdateCall = afroAPIInterface.updateProduct(pro, pro.getProductId());
        productUpdateCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if(response.code()==200)
                updateProductCallBack.onSuccess("success");
                else
                    updateProductCallBack.onError("unKnown n/w Err");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Log.d(TAG, "onFailure: ");
                updateProductCallBack.onError(throwable.getMessage());

            }
        });
    }

    @Override
    public void deleteProduct(int id, final DeleteProductCallBack deleteProductCallBack) {
      Call<Void> productDeleteCall =  afroAPIInterface.deleteProduct(id);

        productDeleteCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==200)
                    deleteProductCallBack.onSuccess("success on n/w");
                else
                    deleteProductCallBack.onError("unknown n/w Err");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                deleteProductCallBack.onError(throwable.getMessage());
            }
        });
    }

    @Override
    public void addProducts(List<Product> product, AddProductsCallBack addProductsCallBack) {

    }
}
