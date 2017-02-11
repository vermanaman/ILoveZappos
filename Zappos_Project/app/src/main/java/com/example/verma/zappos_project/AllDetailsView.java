package com.example.verma.zappos_project;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllDetailsView extends Fragment {

    public AllDetailsView() {
        // Required empty public constructor
    }
    TextView bName;
    TextView pName;
    TextView price;
    TextView oPrice;
    TextView discount;
    TextView email;
    ImageView prodImage;
    Product product;
    Button buyButton;
    BuyProduct buyProduct;


    public void setData(Product product){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buyProduct = (BuyProduct) context;
        }
        catch  (Exception e){}

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_all_details_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = this.getArguments();
        product = (Product) bundle.get("key");
        Log.d("Alldetails fragment",product.toString());
        bName= (TextView)getActivity().findViewById(R.id.textView_brandname1);
        email =(TextView)getActivity().findViewById(R.id.textView_emailURL);
        prodImage = (ImageView)getActivity().findViewById(R.id.imageView_productimage1);
        price = (TextView)getActivity().findViewById(R.id.textView_price1);
        pName = (TextView)getActivity().findViewById(R.id.textView_productname1);
        buyButton = (Button)getActivity().findViewById(R.id.button_buy);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyProduct.getBoughtProduct(product);
            }
        });
        bName.setText(product.getBrandeName());
        pName.setText(product.getProductName());
        price.setText(product.getPrice());
        oPrice =(TextView)getActivity().findViewById(R.id.textView_originalprice1);
        discount = (TextView)getActivity().findViewById(R.id.textView_discount1);
        oPrice.setText(product.getOrginalPrice());
        discount.setText(product.getDiscount());
        Picasso.with(getContext()).load(product.getImageURL()).resize(100, 100).centerCrop().into(prodImage);
        email.setText(product.getProductURL());

    }

    public interface BuyProduct{
        void getBoughtProduct(Product product);
    }
}
