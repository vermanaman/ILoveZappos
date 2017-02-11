package com.example.verma.zappos_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Product> boughtItemList;
    ListView productList;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        message = (TextView) findViewById(R.id.textView_nothingBought);
        productList = (ListView)findViewById(R.id.listView_boughtitem);
        if(getIntent().hasExtra("list")) {
            boughtItemList = (ArrayList<Product>) getIntent().getSerializableExtra("list");
        }
        CartAdapter cartAdapter = new CartAdapter(this,boughtItemList,R.layout.cart_item_layout);
        productList.setAdapter(cartAdapter);

        productList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                boughtItemList.remove(position);
                return false;
            }
        });

    }
}
