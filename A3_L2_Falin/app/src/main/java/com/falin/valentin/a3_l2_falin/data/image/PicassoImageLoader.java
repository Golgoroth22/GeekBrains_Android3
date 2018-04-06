package com.falin.valentin.a3_l2_falin.data.image;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader<ImageView> {

    @NonNull
    private final Picasso picasso;

    public PicassoImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void downloadInfo(String url, ImageView placeHolder) {
        picasso.load(url).into(placeHolder);
    }
}
