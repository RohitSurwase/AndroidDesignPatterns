package com.rohitss.pickandcropimage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static final int IMAGE_CHOOSER_CODE = 100;
    private Context mContext;
    private ImageView cropImageView;
    private ImageUtilityHelper imageUtilityHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        cropImageView = (ImageView) findViewById(R.id.imageView);

        //Step 1. Add Gradle dependency to app-gradle.
        //Step 2. Add CropImageActivity to app-manifest
        //Step 3. Add ImageUtilityHelper class in your project.
        //Step 4. Create object of ImageUtilityHelper class.
        imageUtilityHelper = new ImageUtilityHelper(mContext, cropImageView);
    }

    public void pickAndCropImage(View view) {
        //Step 5. Call image chooser function to get app list.
        startActivityForResult(imageUtilityHelper.getPickImageChooserIntent(), IMAGE_CHOOSER_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Step 6. Call onSelectionResult() function to perform actions on onActivityResult().
        imageUtilityHelper.onSelectionResult(requestCode, resultCode, data);
        //Step 7. Call deleteLocalImage() function to delete temporary/local image. (optional)
        imageUtilityHelper.deleteLocalImage();
    }
}
