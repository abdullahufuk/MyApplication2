package com.example.hp.myapplication;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

public class WebApiTest extends AsyncTask<String,Void,String> {


    @Override
    protected String doInBackground(String... strings) {

        JsonParser jParser=new JsonParser();
        JSONArray jsonArray= jParser.getJSONObjectFromUrl(strings[0]);

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {

    }
}
