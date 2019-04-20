package com.erihackton.shopping.product;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erihackton.shopping.afrosellandroidclient.R;
import com.erihackton.shopping.model.Product;

import java.util.List;

/**
 * Created by aelaf on 2/6/19.
 */

public class CustomProductAdaptor extends RecyclerView.Adapter<CustomProductAdaptor.MeHold> {
    public static final String TAG = "CustomProducAda";
    Context mContext;
    LayoutInflater inflater;
    List<Product> productList;
    RecyclerClickedListener recyclerClickedListener;
    RecyclerLongClickedListener recyclerLongClickedListener;

    public CustomProductAdaptor(Context context, List<Product> productList) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.productList = productList;
    }

    @Override
    public MeHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.product_row, parent, false);
        return new MeHold(v);
    }

    @Override
    public void onBindViewHolder(MeHold holder, int position) {
        holder.name.setText(productList.get(position).getProductName());
        holder.price.setText(productList.get(position).getPrice()+"");
        Log.d(TAG, "onBindViewHolder: "+productList.get(position).getProductCategory());
        holder.category.setText(productList.get(position).getProductCategory());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setClickListener(RecyclerClickedListener recyclerClickedListener) {
        this.recyclerClickedListener = recyclerClickedListener;
    }

    public void setLongClickListener(RecyclerLongClickedListener recyclerLongClickedListener){
        this.recyclerLongClickedListener = recyclerLongClickedListener;
    }

    public class MeHold extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView category;

        public MeHold(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.productName);
            price = (TextView) itemView.findViewById(R.id.productPrice);
            category = (TextView) itemView.findViewById(R.id.productCategory);
            itemView.setTag(itemView);
            //name.setTag
            //tagging
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerClickedListener != null)
                        recyclerClickedListener.onClick(itemView, getAdapterPosition());
                }
            });*/
            itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                        if(recyclerLongClickedListener!=null)
                            recyclerLongClickedListener.onClick(view,getAdapterPosition());
                    return false;
                }
            });
        }
    }
    //interface for click listener

    public interface RecyclerClickedListener {
        void onClick(View v, int position);
    }
    //interface for press and hold

    public interface RecyclerLongClickedListener {
        void onClick(View v, int position);
    }

}
