package com.example.verma.zappos_project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by verma on 2/1/2017.
 */
public class AsyncProductFetch extends AsyncTask<String, Void,ArrayList<Product>> {
    GetContext activity;
    AlertDialog.Builder builder1;
    ProgressDialog progressDialog1;
    public AsyncProductFetch(GetContext activity) {
        this.activity=activity;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog1 = new ProgressDialog(activity.getContext());
        progressDialog1.setMessage("Loading");
        progressDialog1.setMax(100);
        progressDialog1.setCancelable(false);
        progressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog1.show();
        builder1= new AlertDialog.Builder(activity.getContext());
    }
    @Override
    protected ArrayList<Product> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int status= con.getResponseCode();
            if(status== HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();
                while(line!=null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                return JSONParseUtil.JSONParseProduct.parseProduct(stringBuilder.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Product> productArrayList) {
        super.onPostExecute(productArrayList);
        activity.setupData(productArrayList);
        progressDialog1.dismiss();
    }

    public static interface GetContext {
        public Context getContext();
        public void setupData(ArrayList<Product> productArrayList);
    }

}
