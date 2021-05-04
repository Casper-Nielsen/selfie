package com.example.selfie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Activity for loading layout resources
 *
 * This activity is used to display a image
 *
 * @author CKN
 * @version 1.1
 * @since 1.0
 */
public class ImageViewerActivity extends AppCompatActivity {
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        // Gets the image from the intent
        Intent intent = getIntent();
        image = (Bitmap) intent.getExtras().get("image");
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(image);
    }

    /**
     * Method that is for the button click to save the image
     */
    public void onSaveButtonClick(View view){
        Toast.makeText(this, "not implemented", Toast.LENGTH_SHORT).show();
    }

    /**
     * Method that is for the button click to go back
     */
    public void onBackButtonClick(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}