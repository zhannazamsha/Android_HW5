package com.example.den.lesson5.DataSources.Giphy;

import com.example.den.lesson5.DataSources.Unsplash.PhotoItemUnsplash;
import com.example.den.lesson5.Interfaces.PhotoItem;

import java.util.Map;

public class PhotoItemGiphy implements PhotoItem {

    Map<String,PhotoItemGiphy.Image> images;
    PhotoItemGiphy.User user;

    @Override
    public String getImgUrl() {
        return this.images.get("downsized_medium").url;
    }

    @Override
    public String getAuthorName() {
        return this.user.display_name;
    }

    public class User {
        String display_name;
    }

    public class Image {
        String url;
    }


}
