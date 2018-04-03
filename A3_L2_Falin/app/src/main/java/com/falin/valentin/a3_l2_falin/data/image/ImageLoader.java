package com.falin.valentin.a3_l2_falin.data.image;

import android.support.annotation.NonNull;

public interface ImageLoader<T> {
    void downloadInfo(@NonNull String url, T placeHolder);
}
