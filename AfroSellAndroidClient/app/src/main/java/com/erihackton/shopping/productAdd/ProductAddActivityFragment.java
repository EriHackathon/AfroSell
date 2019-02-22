package com.erihackton.shopping.productAdd;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erihackton.shopping.ActivityUtil;
import com.erihackton.shopping.Constants;
import com.erihackton.shopping.afrosellandroidclient.R;
import com.erihackton.shopping.model.Actions;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.model.Rank;
import com.erihackton.shopping.product.ProductActivityFragment;

import java.util.Date;

import retrofit2.http.GET;

import static android.R.id.edit;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductAddActivityFragment extends Fragment implements ProductAddContract.View {
    public static final String TAG = "ProductAddFrag";
    ProductAddContract.Presenter mPresenter;
    private boolean isEdit = false;

    EditText edtProductName;
    EditText edtProductCategory;
    EditText edtproductprice;
    EditText edtProductType;
    int productId;
    TextInputEditText txtEdtInProductDescription;
    Button buttAddProduct;
    View v;
    public  static ProductAddActivityFragment instance;
    public static ProductAddActivityFragment getInstance(){
        if (instance==null)
            instance = new ProductAddActivityFragment();
        return  instance;
    }
    public ProductAddActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_product_add, container, false);
        edtProductName = (EditText)v.findViewById(R.id.edtproductName);
        edtProductCategory = (EditText)v.findViewById(R.id.edtProductCat);
        edtproductprice = (EditText) v.findViewById(R.id.edtProductPrice);
        edtProductType = (EditText) v.findViewById(R.id.edtProductType);
        txtEdtInProductDescription = (TextInputEditText) v.findViewById(R.id.edtProductDescription);
        buttAddProduct = (Button) v.findViewById(R.id.buttAddProduct);
        Intent intent = getActivity().getIntent();
        if(intent !=null){
            isEdit = intent.getBooleanExtra(Constants.PRODUCT_INTENT_EDIT,false);
            Log.d(TAG, "onCreateView: Intent On "+ isEdit);

            if(isEdit){
                Product product = intent.getParcelableExtra(Constants.PRODUCT_INTENT_OBJECT);
                Log.d(TAG, "onCreateView:>> "+product.getProductName());
                productId= product.getProductId();
                edtProductName.setText(product.getProductName());
                edtProductCategory.setText(product.getProductCategory());
                edtproductprice.setText(product.getPrice()+"");
                edtProductType.setText(product.getProductType());
                txtEdtInProductDescription.setText(product.getProductDiscription());
                buttAddProduct.setText(getActivity().getString(R.string.button_edit));
            }
            else{
                buttAddProduct.setText(getActivity().getString(R.string.button_add));

                Log.d(TAG, "onCreateView: intent off");
            }

        }

        buttAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = edtProductName.getText().toString().trim();
                String productCategory = edtProductCategory.getText().toString().trim();
                String priceSt = edtproductprice.getText().toString().trim();
                double productPrice =  priceSt==""?0.0:Double.parseDouble(priceSt);
                String  productType = edtProductType.getText().toString().trim();
                String productDescription = txtEdtInProductDescription.getText().toString().trim();
                Product product = new Product(productName,productPrice);

                product.setProductCategory(productCategory);
                product.setProductType(productType);
                product.setProductDiscription(productDescription);
                product.setDateCreated(new Date());
                product.setDateDeleted(null);
                if (isEdit){
                    product.setProductId(productId);
                    goUpdateProduct(product);
                }

                else{
                    goAddProduct(product);
                }



            }
        });
        return v;
    }

    private void goAddProduct(Product product) {

        mPresenter.addProduct(product);

    }
    private void goUpdateProduct(Product product){
        mPresenter.updateProduct(product);
    }

    @Override
    public void setPresenter(ProductAddContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.start(getActivity());
    }

    @Override
    public void showAddedProduct(Product product) {
        Toast.makeText(getActivity(),"Successfully Added "+product.getProductName(), Toast.LENGTH_LONG).show();
        getActivity().setResult(getActivity().RESULT_OK,new Intent().putExtra(Constants.PRODUCT_INTENT_OBJECT,product));
        getActivity().finish();
    }

    @Override
    public void showNoAddedProduct(String err) {
        Toast.makeText(getContext(),err, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUpdateProduct(Product product) {
        Toast.makeText(getActivity(),"Successfully Updated "+product.getProductName(), Toast.LENGTH_LONG).show();

        getActivity().setResult(getActivity().RESULT_OK,new Intent().putExtra(Constants.PRODUCT_INTENT_OBJECT,product));
        getActivity().finish();

    }

    @Override
    public void showNoUpdateProduct(String err) {
        getActivity().setResult(getActivity().RESULT_CANCELED);
        getActivity().finish();
    }
}
