package com.example.den.lesson5.Presenters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.den.lesson5.Interfaces.PhotoItem;
import com.example.den.lesson5.R;
import com.squareup.picasso.Picasso;

public class PhotoArrayAdapter extends ArrayAdapter {

    private PhotoItem[] photoItems;
    private Activity activity;

    PhotoArrayAdapter(Activity activity, int resource, PhotoItem[] photoItems){
        super(activity, resource, photoItems);
        this.photoItems = photoItems;
        this.activity = activity;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
        PhotoItem photoItem = photoItems[position];
        // Inflate only once
        if (convertView == null) {
            convertView = activity.getLayoutInflater()
                    .inflate(R.layout.custom_item_img, null, false);
        }

        ViewHolder viewHolder;
        if(convertView.getTag() == null) {
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else  {
            viewHolder = (ViewHolder)convertView.getTag();
        }


        viewHolder.textViewAuthor.setText(photoItem.getAuthorName());
        Picasso.get().load(photoItem.getImgUrl()).into(viewHolder.imageViewPhoto);
        return convertView;

    }
}
