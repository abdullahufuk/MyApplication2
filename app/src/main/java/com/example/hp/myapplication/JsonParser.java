package com.example.hp.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonParser {



    public String readAll(Reader reader){
        StringBuilder sb=new StringBuilder();
        int cp;
        try {
            while((cp=reader.read())!=-1){
                sb.append((char)cp);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }

    public JSONArray getJSONObjectFromUrl(String url){
        JSONArray jsonArray=null;
        try {
            InputStream inputStream=new URL(url).openStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText=readAll(bufferedReader);
            jsonArray=new JSONArray(jsonText);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonArray;
    }
}