package com.erihackton.shopping.product;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erihackton.shopping.afrosellandroidclient.R;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.productAdd.ProductAddActivity;
import com.erihackton.shopping.welcome.WelcomeActivity;

import java.util.Arrays;
import java.util.List;

import static android.util.Config.LOGD;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductActivityFragment extends Fragment implements ProductContract.View{
    public static final String TAG = "ProductActivityFrag";
    RecyclerView recyclerView;
    FloatingActionButton fab;
    ProductContract.Presenter mPresenter;
    TextView txtProductErr;
    public static ProductActivityFragment productActivityFragment;
    public static ProductActivityFragment getInstance(){
        if(productActivityFragment==null)
            productActivityFragment = new ProductActivityFragment();
        return productActivityFragment;
    }
    public ProductActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerProduct);
        fab = (FloatingActionButton) view.findViewById(R.id.fabAddProduct);
        txtProductErr = (TextView) view.findViewById(R.id.txtProductErr);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,true );
        recyclerView.setLayoutManager(linearLayoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivityFragment.this.getActivity(), ProductAddActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void setPresenter(ProductContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.start(getActivity());
    }

    @Override
    public void showListofProducts(final List<Product> productList) {
        Log.d(TAG, "showListofProducts: "+productList.size());
        final CustomProductAdaptor productAdaptor = new CustomProductAdaptor(getContext(),productList);
        recyclerView.setVisibility(View.VISIBLE);
        txtProductErr.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(productAdaptor);
        //click list
        productAdaptor.setClickListener(new CustomProductAdaptor.RecyclerClickedListener() {
            @Override
            public void onClick(View v, int position) {

                /**
                 * TODO
                 * FURTHER ACTION: TO BE USED WITH STAGGERED LAYOUT
                 * &&
                 * BOTTOM SHEET for product detail
                 */


            }
        });
        productAdaptor.setLongClickListener(new CustomProductAdaptor.RecyclerLongClickedListener() {
            @Override
            public void onClick(View v, int position) {
                //update or delete action
                //menu action?!
                Snackbar.make(v,productList.get(position).getProductName(),Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showNoProducts() {
    recyclerView.setVisibility(View.INVISIBLE);
        txtProductErr.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddProduct() {

    }

    @Override
    public void showUpdateProduct() {

    }
}
