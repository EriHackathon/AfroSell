package com.erihackton.shopping.domain;

import android.content.Context;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;
import com.erihackton.shopping.source.DataSourceRepository;

/**
 * Created by aelaf on 2/6/19.
 */

public class AddProduct extends UseCase<AddProduct.RequestValues,AddProduct.ResponseValue,String> {
public static final String TAG ="AddProductUseCase";
    DataSourceRepository dataSourceRepository ;

    public AddProduct(Context context) {
        dataSourceRepository = DataSourceRepository.getInstance(context);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        dataSourceRepository.addProduct(requestValues.getProduct(), new DataSource.AddProductCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                AddProduct.ResponseValue responseValue = new ResponseValue(result);
                AddProduct.this.getmUseCaseCallback().onSucess(responseValue);
            }

            @Override
            public void onError(String err) {

                Log.d(TAG, "onError: "+err);
                AddProduct.this.getmUseCaseCallback().onError(err);
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{
        private Product product;

        public RequestValues(Product product) {
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }
    }
    public static class ResponseValue implements UseCase.ResponseValue{
        private String productAddResult;

        public ResponseValue(String productAddResult) {
            this.productAddResult = productAddResult;
        }

        public String getProductAddResult() {
            return productAddResult;
        }
    }
}
