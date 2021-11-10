package com.ucas.android.parsejson.glide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.ucas.android.parsejson.R;

public class LoadImageUsingGlideActivity extends AppCompatActivity {

    ImageView imageView;
    String url = "https://cdn.wallpapersafari.com/8/52/gb62PU.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_using_glide);
        imageView = findViewById(R.id.imageView);
        RequestOptions requestOptions = new RequestOptions().transform(new FitCenter(),new RoundedCorners(20));
        Glide.with(this).load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .transition(DrawableTransitionOptions.withCrossFade())
                //.apply(requestOptions)
                .circleCrop()
                .into(imageView);
    }
}