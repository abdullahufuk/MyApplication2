package com.example.hp.myapplication;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

public class WebApiTest extends AsyncTask<URL,Void,String> {



    @Override
    protected String doInBackground(URL... urls) {
        JsonParser jParser=new JsonParser();
         JSONArray jsonArray= jParser.getJSONObjectFromUrl(urls[0].toString());

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {

    }
}
