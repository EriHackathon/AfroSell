package com.erihackton.shopping.domain;

import android.content.Context;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.source.DataSource;
import com.erihackton.shopping.source.DataSourceRepository;

/**
 * Created by aelaf on 2/6/19.
 */

public class DeleteProduct extends UseCase<DeleteProduct.RequestValues,DeleteProduct.ResponseValue,String> {
    private DataSourceRepository dataSourceRepository;

    public DeleteProduct(Context context) {
        dataSourceRepository = DataSourceRepository.getInstance(context);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        dataSourceRepository.deleteProduct(requestValues.getProductId(), new DataSource.DeleteProductCallBack() {
            @Override
            public void onSuccess(String result) {
                DeleteProduct.ResponseValue delResponseValue = new DeleteProduct.ResponseValue(result);
                DeleteProduct.this.getmUseCaseCallback().onSucess(delResponseValue);

            }

            @Override
            public void onError(String err) {
                DeleteProduct.this.getmUseCaseCallback().onError(err);
            }
        });
    }


    public static class RequestValues implements UseCase.RequestValues{
        private int productId;

        public RequestValues(int productId) {
            this.productId = productId;
        }

        public int getProductId() {
            return productId;
        }
    }

    public static class ResponseValue implements UseCase.ResponseValue{
        private String productDeleteResult;

        public ResponseValue(String productDeleteResult) {
            this.productDeleteResult = productDeleteResult;
        }

        public String getProductDeleteResult() {
            return productDeleteResult;
        }
    }
}
