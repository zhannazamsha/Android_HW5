package com.example.den.lesson5.DataSources.Giphy;

import android.util.Log;

import com.example.den.lesson5.Interfaces.NetworkingManager;
import com.example.den.lesson5.Interfaces.NetworkingResultListener;
import com.example.den.lesson5.Interfaces.PhotoItem;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkingManagerGiphy implements NetworkingManager {
    @Override
    public void getPhotoItems(NetworkingResultListener result) {
        Request request = new Request.Builder()
                .url("https://api.giphy.com/v1/stickers/trending?api_key=VvyONhZ6eUFDFtuwg7w9tUYXzgefYdYy&limit=25&rating=G")
                .build();

        final Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        JsonParser parser = new JsonParser();
        final ArrayList<PhotoItem> photoItems = new ArrayList<PhotoItem>();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    parseGiphyResponse(jsonData, parser, gson, photoItems);
                } catch (Exception ex) {
                    Log.e("ERROR",ex.getLocalizedMessage());
                } finally {
                    result.callback(photoItems.toArray(new PhotoItem[photoItems.size()]));
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }});
    }

    private void parseGiphyResponse(String response, JsonParser parser, Gson gson, ArrayList<PhotoItem> photoItems) throws JSONException {
        JSONObject object = new JSONObject(response);
        JSONArray array = object.getJSONArray("data");
        for (int i = 0; i < array.length(); i++) {
            JSONObject imgObject = array.getJSONObject(i);
            JsonElement mJson = parser.parse(imgObject.toString());
            PhotoItem photoItem = gson.fromJson(mJson, PhotoItemGiphy.class);
            photoItems.add(photoItem);
        }
    }
}
