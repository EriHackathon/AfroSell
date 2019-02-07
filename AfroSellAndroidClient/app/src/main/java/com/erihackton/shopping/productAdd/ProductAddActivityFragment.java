package com.erihackton.shopping.productAdd;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erihackton.shopping.afrosellandroidclient.R;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.product.ProductActivityFragment;

import java.util.Date;

import static android.R.id.edit;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductAddActivityFragment extends Fragment implements ProductAddContract.View {

    ProductAddContract.Presenter mPresenter;

    EditText edtProductName;
    EditText edtProductCategory;
    EditText edtproductprice;
    EditText edtProductType;
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
        edtProductType = (EditText) v.findViewById(R.id.edtProductDescription);
        txtEdtInProductDescription = (TextInputEditText) v.findViewById(R.id.edtProductDescription);
        buttAddProduct = (Button) v.findViewById(R.id.buttAddProduct);
        buttAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAddProduct();
            }
        });
        return v;
    }

    private void goAddProduct() {
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
        mPresenter.addProduct(product);

    }

    @Override
    public void setPresenter(ProductAddContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.start(getActivity());
    }

    @Override
    public void showAddedProduct(Product product) {
        Toast.makeText(getActivity(),"Successfully Added "+product.getProductName(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void showNoAddedProduct(String err) {
        Toast.makeText(getContext(),err, Toast.LENGTH_LONG).show();
    }
}
