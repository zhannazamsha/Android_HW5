package com.example.den.lesson5.Presenters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.den.lesson5.Interfaces.PhotoItem;
import com.example.den.lesson5.Interfaces.PhotoItemsPresenter;
import com.example.den.lesson5.R;
import com.squareup.picasso.Picasso;

public class PhotoItemPresenterGridView implements PhotoItemsPresenter {

    public void setupWithPhotoItems(PhotoItem[] photoItems, Activity activity) {
        ArrayAdapter<PhotoItem> photoAdapter = new PhotoArrayAdapter(activity, 0, photoItems);
        GridView itemGrid = new GridView(activity);
        activity.setContentView(itemGrid);
        itemGrid.setNumColumns(2);
        itemGrid.setColumnWidth(40);
        itemGrid.setVerticalSpacing(20);
        itemGrid.setHorizontalSpacing(20);
        itemGrid.setAdapter(photoAdapter);
    }
}
