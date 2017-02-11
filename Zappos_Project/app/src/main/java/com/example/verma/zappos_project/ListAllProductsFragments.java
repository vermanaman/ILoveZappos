package com.example.verma.zappos_project;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ListAllProductsFragments extends Fragment implements AsyncProductFetch.GetContext{

    String key;
    ArrayList<Product> productArrayList;
    EditText editText_key;
    RecyclerView productRecyclerView;
    ImageButton imageButton_search;
    AsyncProductFetch.GetContext context;
    GetData getData;
    public ListAllProductsFragments() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            getData = (GetData) context;
        }
        catch  (Exception e){}

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
        productRecyclerView = (RecyclerView) getActivity().findViewById(R.id.RecyclerView_list);
        editText_key=(EditText) getActivity().findViewById(R.id.editText_key);
        imageButton_search = (ImageButton) getActivity().findViewById(R.id.imageButton_search);
        imageButton_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editText_key.getText().toString().trim();
                Log.d("key",key);
                new AsyncProductFetch(ListAllProductsFragments.this).execute("https://api.zappos.com/Search?term="+key+"&key=b743e26728e16b81da139182bb2094357c31d331");
            }
        });
        new AsyncProductFetch(ListAllProductsFragments.this).execute("https://api.zappos.com/Search?term=&key=b743e26728e16b81da139182bb2094357c31d331");
        productRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), productRecyclerView, new RecyclerTouchListener.RecycleClickListener() {
            @Override
            public void onClick(View view, int position) {

                Product product = productArrayList.get(position);
                Log.d("fragment selected item",productArrayList.get(position).toString());
                getData.getSelectedProduct(product);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_all_products_fragments,container,false);

        return view;
    }

    @Override
    public Context getContext() {
        context= (AsyncProductFetch.GetContext) getActivity().getParent();
        return getActivity();
    }

    @Override
    public void setupData(final ArrayList<Product> productArrayList) {
        this.productArrayList=productArrayList;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),productArrayList);
        productRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        productRecyclerView.setLayoutManager(layoutManager);

    }


    public interface GetData{
        void getSelectedProduct(Product product);
    }
}
