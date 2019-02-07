package com.erihackton.shopping.domain;

import android.content.Context;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;
import com.erihackton.shopping.source.DataSourceRepository;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.List;

/**
 * Created by aelaf on 2/6/19.
 */

public class GetProducts extends UseCase<GetProducts.RequestValues,GetProducts.ResponseValue,String> {

    private DataSourceRepository dataSourceRepository;

    public GetProducts(Context context) {
      dataSourceRepository = DataSourceRepository.getInstance(context);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        dataSourceRepository.getAllProducts(new DataSource.GetAllProductsCallBack() {
            @Override
            public void onSuccess(List<Product> productList) {
                //got product list from network
                ResponseValue responseValue = new ResponseValue(productList);
                getmUseCaseCallback().onSucess(responseValue);
            }

            @Override
            public void onError(String err) {
            getmUseCaseCallback().onError(err);
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{

    }
    public static class ResponseValue implements UseCase.ResponseValue{
      private   List<Product> productList;

        public ResponseValue(List<Product> productList) {
            this.productList = productList;
        }

        public List<Product> getProductList() {
            return productList;
        }
    }
}
