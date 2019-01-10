package com.example.den.lesson5.Presenters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.den.lesson5.Interfaces.PhotoItem;
import com.example.den.lesson5.Interfaces.PhotoItemsPresenter;
import com.example.den.lesson5.R;
import com.squareup.picasso.Picasso;

public class PhotoItemPresenterListView implements PhotoItemsPresenter {
    @Override
    public void setupWithPhotoItems(PhotoItem[] photoItems, Activity activity) {
        ArrayAdapter<PhotoItem> photoAdapter = new PhotoArrayAdapter(activity, 0, photoItems);
        ListView itemList = new ListView(activity);
        activity.setContentView(itemList);
        itemList.setAdapter(photoAdapter);
    }
}
