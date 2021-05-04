package com.example.selfie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Activity for loading layout resources
 *
 * This activity is used to display buttons that will open the camera app
 *
 * @author CKN
 * @version 1.1
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {
    private int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method that is for the button click to open the camera
     */
    public void onButtonTakeClicked(View view){
        dispatchTakePictureIntent();
    }

    /**
     * Method that opens the camera
     */
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "error can't open the camera", Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * Method that takes the data from the camera and sends it to another activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Gets the preview
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Opens the other activity
            Intent intent = new Intent(this,ImageViewerActivity.class);
            intent.putExtra("image",imageBitmap);
            startActivity(intent);
        }
    }
}