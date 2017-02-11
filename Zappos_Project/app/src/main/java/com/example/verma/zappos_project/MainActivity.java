package com.example.verma.zappos_project;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListAllProductsFragments.GetData, AllDetailsView.BuyProduct {

    Product selectedProduct;
    ArrayList<Product> bought_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bought_item = new ArrayList<Product>();
        getFragmentManager().beginTransaction().add(R.id.parentContainer,new ListAllProductsFragments(),"AllProducts").commit();
    }

    @Override
    public void getSelectedProduct(Product product) {
        selectedProduct = product;
        Log.d("Main Activty selected",product.toString());

       /* Bundle bundle = new Bundle();

        bundle.putSerializable("product",product);

        AllDetailsView fragment = new AllDetailsView();
        fragment.setArguments(bundle);*/

        AllDetailsView newFragment = new AllDetailsView();
        Bundle args = new Bundle();
        args.putSerializable("key",product);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.parentContainer, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

       /* FragmentTransaction ft =getFragmentManager().beginTransaction();
        AllDetailsView allDetailsView = (AllDetailsView) getFragmentManager().findFragmentByTag("AllDetailsView");
        if(allDetailsView!=null)
            allDetailsView.setData(product);*/
    }

    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void getBoughtProduct(Product product) {
        bought_item.add(product);
    }
}
