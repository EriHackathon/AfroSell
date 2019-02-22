package com.erihackton.shopping.domain;

import android.content.Context;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.source.DataSource;
import com.erihackton.shopping.source.DataSourceRepository;

import static com.erihackton.shopping.product.ProductActivity.TAG;

/**
 * Created by aelaf on 2/6/19.
 */

public class UpdateProduct extends UseCase<UpdateProduct.RequestValues, UpdateProduct.ResponseValue, String> {
    public static final String TAG = "UpdateProduct";
    DataSourceRepository dataSourceRepository;


    public UpdateProduct(Context context) {
        this.dataSourceRepository = DataSourceRepository.getInstance(context);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        Log.d(TAG, "executeUseCase: ");
        dataSourceRepository.updateProduct(requestValues.getProduct(), new DataSource.UpdateProductCallBack() {
            @Override
            public void onSuccess(String result) {
                UpdateProduct.ResponseValue updateResponseValue = new UpdateProduct.ResponseValue(result);
                UpdateProduct.this.getmUseCaseCallback().onSucess(updateResponseValue);

            }

            @Override
            public void onError(String err) {
               UpdateProduct.this.getmUseCaseCallback().onError(err);
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues {
        private Product product;

        public RequestValues(Product product) {
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }
    }

    public static class ResponseValue implements UseCase.ResponseValue {
        private String productUpdateResult;

        public ResponseValue(String productUpdateResult) {
            this.productUpdateResult = productUpdateResult;
        }
        public String getProductUpdateResult() {
            return productUpdateResult;
        }
    }
}
