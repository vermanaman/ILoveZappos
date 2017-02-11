package com.example.verma.zappos_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by verma on 2/1/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView bName;
        TextView pName;
       // TextView oPrice;
        ImageView prodImage;
        TextView price;
       // TextView discount;
        public View v;
        public ViewHolder(View itemView) {
            super(itemView);
            v = itemView;

            bName = (TextView)v.findViewById(R.id.textView_brandname1);
            pName = (TextView)v.findViewById(R.id.textView_productname1);
            price = (TextView)v.findViewById(R.id.textView_price);
            //oPrice =(TextView)v.findViewById(R.id.textView_originalprice);
            //discount = (TextView)v.findViewById(R.id.textView_discount);
            prodImage = (ImageView)v.findViewById(R.id.imageView_productimage);

        }
    }

    // Store a member variable for the contacts
    private List<Product> productList;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public RecyclerViewAdapter(Context context,List<Product> productList) {
        this.productList=productList;
        mContext = context;

    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View dayView = inflater.inflate(R.layout.row_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(dayView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, final int position) {
        Product product = productList.get(position);


        viewHolder.pName.setText(product.getProductName());
        viewHolder.bName.setText(product.getBrandeName());
        viewHolder.price.setText(product.getPrice());
        /*viewHolder.oPrice.setText(product.getOrginalPrice());
        if (product.getDiscount().equals("0%")) {
            viewHolder.discount.setText("");
            viewHolder.price.setText("");
        }else{
            viewHolder.discount.setText("-"+product.getDiscount());
            viewHolder.price.setText(product.getPrice());
            viewHolder.oPrice.setPaintFlags(viewHolder.oPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }*/

        Picasso.with(getContext()).load(product.getImageURL()).into(viewHolder.prodImage);

        /*viewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
