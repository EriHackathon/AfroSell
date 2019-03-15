package com.erihackton.shopping.productAdd;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erihackton.shopping.Constants;
import com.erihackton.shopping.afrosellandroidclient.R;
import com.erihackton.shopping.model.Product;

import org.w3c.dom.Text;

import java.util.Date;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductAddActivityFragment extends Fragment implements ProductAddContract.View {
    public static final String TAG = "ProductAddFrag";
    ProductAddContract.Presenter mPresenter;
    private boolean isEdit = false;

    EditText edtProductName;
    TextInputLayout layoutproductName;
    EditText edtProductCategory;
    TextInputLayout layoutProductCategory;
    EditText edtproductprice;
    TextInputLayout layoutProductprice;
    EditText edtProductType;
    TextInputLayout layoutProductType;

    int productId;
    TextInputEditText txtEdtInProductDescription;

    EditText edtproductDescription;
    TextInputLayout layoutProductDescription;
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
        v = inflater.inflate(R.layout.fragment_product_add_x, container, false);
        getProductAddLayout(v);

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
                edtproductDescription.setText(product.getProductDiscription());
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
                String productDescription = edtproductDescription.getText().toString().trim();
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

    private void getProductAddLayout(View v) {
        edtProductName = (EditText)v.findViewById(R.id.productNameX);
        edtProductCategory = (EditText)v.findViewById(R.id.productCategoryX);
        edtproductprice = (EditText) v.findViewById(R.id.productPriceX);
        edtProductType = (EditText) v.findViewById(R.id.productTypeX);
        edtproductDescription = (EditText) v.findViewById(R.id.productDiscriptionX);
        buttAddProduct = (Button) v.findViewById(R.id.buttAddProductX);
        //layout
      layoutproductName =  (TextInputLayout) v.findViewById(R.id.productNameX_text_input_layout);
        layoutProductCategory =(TextInputLayout) v.findViewById(R.id.productCategoryX_text_input_layout);
        layoutProductprice = (TextInputLayout) v.findViewById(R.id.productPriceX_text_input_layout) ;
        layoutProductType = (TextInputLayout) v.findViewById(R.id.productTypeX_text_input_layout);
        layoutProductDescription = (TextInputLayout) v.findViewById(R.id.productDiscriptionX_text_input_layout);
        /**
         * Product name Error handling
         */
        layoutproductName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if(text.length()==0){
                    layoutproductName.setError("Product Name  needed");
                    layoutproductName.setErrorEnabled(true);
                    buttAddProduct.setEnabled(false);
                }
                else{
                    layoutproductName.setErrorEnabled(false);
                    buttAddProduct.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /**
         * Product Category Error handling
         */
        layoutProductCategory.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {

                if(text.length()==0){
                    layoutProductCategory.setError("Product Category  needed");
                    layoutProductCategory.setErrorEnabled(true);
                    buttAddProduct.setEnabled(false);
                }
                else{
                    layoutProductCategory.setErrorEnabled(false);
                    buttAddProduct.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /**
         * Product Price Error handling
         */
        layoutProductprice.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if(text.length()==0){
                    layoutProductprice.setError("Product Price  needed");
                    layoutProductprice.setErrorEnabled(true);
                    buttAddProduct.setEnabled(false);
                }
                else{
                    layoutProductprice.setErrorEnabled(false);
                    buttAddProduct.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        /**
         * Product Type Error handling
         */
        layoutProductType.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if(text.length()==0){
                    layoutProductType.setError("Product Price  needed");
                    layoutProductType.setErrorEnabled(true);
                    buttAddProduct.setEnabled(false);
                }
                else{
                    layoutProductType.setErrorEnabled(false);
                    buttAddProduct.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        layoutProductDescription.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if(text.length()==0){
                    layoutProductDescription.setError("Product Description  needed");
                    layoutProductDescription.setErrorEnabled(true);
                    buttAddProduct.setEnabled(false);
                }
                else{
                    layoutProductDescription.setErrorEnabled(false);
                    buttAddProduct.setEnabled(true);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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
