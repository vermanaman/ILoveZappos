package com.example.verma.zappos_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by verma on 2/10/2017.
 */
public class CartAdapter extends ArrayAdapter<Product> {
    Context context;
    ArrayList<Product> productArrayList;
    int resource;

    public CartAdapter(Context context, ArrayList<Product> productArrayList, int resource   ) {
        super(context, resource, productArrayList);
        this.context = context;
        this.productArrayList = productArrayList;
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }

        Product product = productArrayList.get(position);
        TextView name = (TextView)convertView.findViewById(R.id.textView_pName);
        name.setText(product.productName);
        TextView price = (TextView)convertView.findViewById(R.id.textView_pprice);
        price.setText(product.price);
        ImageView productImage=(ImageView)convertView.findViewById(R.id.imageView_pImage);
        Picasso.with(getContext()).load(product.imageURL).centerCrop().into(productImage);

        return convertView;
    }
}
