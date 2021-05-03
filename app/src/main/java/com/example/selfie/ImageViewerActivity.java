package com.example.selfie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewerActivity extends AppCompatActivity {
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        Intent intent = getIntent();
        image = (Bitmap) intent.getExtras().get("image");
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(image);
    }
}