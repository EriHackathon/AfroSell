package com.erihackton.shopping.product;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.erihackton.shopping.Constants;
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
public class ProductActivityFragment extends Fragment implements ProductContract.View {
    public static final String TAG = "ProductActivityFrag";
    public static final int REQUEST_CODE_EDIT = 0;
    RecyclerView recyclerView;
    FloatingActionButton fab;
    ProductContract.Presenter mPresenter;
    TextView txtProductErr;
    public static ProductActivityFragment productActivityFragment;
    private Product productToModify;
    //action mode
    private ActionMode mActionMode;
    //recyclerView
    CustomProductAdaptor productAdaptor;
    List<Product> products;
    int recyEditPosition;
    private ActionMode.Callback mActionCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Log.d(TAG, "onCreateActionMode: ");
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_contextual, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.d(TAG, "onPrepareActionMode: ");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.d(TAG, "onActionItemClicked: ");
            switch (item.getItemId()) {
                case R.id.action_edit:
                    // editProduct(selectedProduct);
                    //does need a call back
                    Intent editIntent = new Intent(getActivity(), ProductAddActivity.class);
                    editIntent.putExtra(Constants.PRODUCT_INTENT_OBJECT, productToModify);
                    editIntent.putExtra(Constants.PRODUCT_INTENT_EDIT, true);
                    startActivityForResult(editIntent, Constants.REQUEST_CODE_EDIT);

                    mode.finish();
                    return true;
                case R.id.action_delete:
                    mPresenter.deleteProduct(productToModify.getProductId());

                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.d(TAG, "onDestroyActionMode: ");
            mActionMode = null;
        }
    };

    public static ProductActivityFragment getInstance() {
        if (productActivityFragment == null)
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(linearLayoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProductAddActivity.class);
                intent.putExtra(Constants.PRODUCT_INTENT_EDIT, false);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
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
        Log.d(TAG, "showListofProducts: " + productList.size());
        products = productList;
        productAdaptor = new CustomProductAdaptor(getContext(), products);
        recyclerView.setVisibility(View.VISIBLE);
        txtProductErr.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(productAdaptor);

        //click list
        productAdaptor.setClickListener(new CustomProductAdaptor.RecyclerClickedListener() {
            @Override
            public void onClick(View v, int position) {

               /* *
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
                if (mActionMode != null) {
                    Log.d(TAG, "onClick: form non -null");
                    mActionMode.setTitle(productList.get(position).getProductId() + "...");

                }
                Log.d(TAG, "onClick: from null>> " + mActionCallback);
                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = ProductActivityFragment.this.getActivity().startActionMode(mActionCallback);
                productToModify = productList.get(position);
                mActionMode.setTitle(productList.get(position).getProductId() + "...");
                recyEditPosition = position;

            }
        });
    }

    @Override
    public void showNoProducts() {
        recyclerView.setVisibility(View.INVISIBLE);
        txtProductErr.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddProduct(Product pro) {
        products.add(pro);
        productAdaptor.notifyDataSetChanged();
    }

    @Override
    public void showNoAddProduct() {
       /* 5kh
                26n*/
    }

    @Override
    public void showUpdateProduct(Product pro) {
        // products.
        Log.d(TAG, "showUpdateProduct: ");
        products.set(recyEditPosition, pro);
        productAdaptor.notifyDataSetChanged();
    }

    @Override
    public void showNoUpdateProduct() {

    }

    @Override
    public void showDeleteProduct(int id) {
        Log.d(TAG, "showDeleteProduct: " + id);

        products.remove(productToModify);
        productAdaptor.notifyDataSetChanged();

    }

    @Override
    public void showNoDeleteProduct() {
        Toast.makeText(getContext(), "can not delete", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: "+resultCode);
        if(resultCode!=0) {

            Product pro = data.getParcelableExtra(Constants.PRODUCT_INTENT_OBJECT);
            Log.d(TAG, "onActivityResult: " + pro.getProductName());
            Log.d(TAG, "onActivityResult: from frag!!!");
            showUpdateProduct(pro);
        }
    }


}
