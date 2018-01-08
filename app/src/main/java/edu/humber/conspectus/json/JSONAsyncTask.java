package edu.humber.conspectus.json;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.humber.conspectus.fragment.ConceptFragment;

public class JSONAsyncTask extends AsyncTask<String, String, String> {
    private JSONCallBack jsonCallBack;
    private String urlString;

    public JSONAsyncTask(JSONCallBack jsonCallBack, String url) {
        this.jsonCallBack = jsonCallBack;
        this.urlString = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection conn;
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.toString();
        }
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
        } catch (IOException e1) {
            e1.printStackTrace();
            return e1.toString();
        }
        try {
            int response_code = conn.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream input = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return (result.toString());
            } else {
                InputStream input = conn.getErrorStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return (result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        } finally {
            conn.disconnect();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            Log.e("LUMEN", result);
            JSONArray jsonArray = new JSONArray(result);
            jsonCallBack.success(jsonArray);
        } catch (JSONException e) {
            jsonCallBack.failed();
            e.printStackTrace();
        }
    }
}
