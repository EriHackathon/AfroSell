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
                //then add into local !!! access from network
                //expect Remote response Data
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
    public void updateProduct(final Product pro, final UpdateProductCallBack updateProductCallBack) {
        afroSellRemoteDataSource.updateProduct(pro, new UpdateProductCallBack() {
            @Override
            public void onSuccess(String result) {
                //remote success
                Log.d(TAG, "onSuccess from Remote: "+result);
                //update local
                afroSellLocalDataSource.updateProduct(pro, new UpdateProductCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        //local success
                        Log.d(TAG, "onSuccess:from Db "+result);
                        updateProductCallBack.onSuccess(result);
                    }

                    @Override
                    public void onError(String err) {
                            //local Error
                        Log.d(TAG, "onError:from Db "+err);
                        updateProductCallBack.onError(err);
                    }
                });
            }

            @Override
            public void onError(String err) {
                //remote fail
                Log.d(TAG, "onError: from Remote "+err);
            }
        });

    }

    @Override
    public void deleteProduct(final int id, final DeleteProductCallBack deleteProductCallBack) {
        Log.d(TAG, "deleteProduct: init");
        afroSellRemoteDataSource.deleteProduct(id, new DeleteProductCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: delete from n/w");
                //going to local delete
                afroSellLocalDataSource.deleteProduct(id, new DeleteProductCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        Log.d(TAG, "onSuccess: delete on n/w");
                        deleteProductCallBack.onSuccess(result);
                    }

                    @Override
                    public void onError(String err) {
                        Log.d(TAG, "onError: "+err);
                        deleteProductCallBack.onError(err);
                    }
                });
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: on n/w "+err);
                deleteProductCallBack.onError(err);
            }
        });
    }

    @Override
    public void addProducts(List<Product> product, AddProductsCallBack addProductsCallBack) {

    }
}
