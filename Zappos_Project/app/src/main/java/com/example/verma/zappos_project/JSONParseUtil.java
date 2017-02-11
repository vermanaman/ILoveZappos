package com.example.verma.zappos_project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by verma on 2/1/2017.
 */
public class JSONParseUtil {
    public static  class JSONParseProduct{
        static ArrayList<Product> parseProduct(String in) throws JSONException {
            ArrayList<Product> productList = new ArrayList<Product>();
            JSONObject root = new JSONObject(in);

            JSONArray productArray = root.getJSONArray("results");
            for(int i = 0 ; i< productArray.length();i++) {

                JSONObject jsonObject = productArray.getJSONObject(i);
                Product product = new Product();
                product.setBrandeName(jsonObject.getString("brandName"));
                product.setColorID(jsonObject.getString("colorId"));
                product.setDiscount(jsonObject.getString("percentOff"));
                product.setImageURL(jsonObject.getString("thumbnailImageUrl"));
                product.setOrginalPrice(jsonObject.getString("originalPrice"));
                product.setStyleID(jsonObject.getString("styleId"));
                product.setProductURL(jsonObject.getString("productUrl"));
                product.setProductName(jsonObject.getString("productName"));
                product.setPrice(jsonObject.getString("price"));
                product.setProductID(jsonObject.getString("productId"));
                productList.add(product);
            }
            return productList;
        }
    }
}
