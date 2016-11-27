package com.rohitss.pickandcropimage;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static final int IMAGE_CHOOSER_CODE = 100;
    private static final int WRITE_PERMISSION_CODE = 5;
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
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION_CODE);
        } else {
            //TODO: Function that requires permission
            getImageChooser();
        }
    }

    private void getImageChooser() {
        //Step 5. Call image chooser function to get app list.
        Intent imageChooserIntent = imageUtilityHelper.getPickImageChooserIntent();
        startActivityForResult(imageChooserIntent, IMAGE_CHOOSER_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Step 6. Call onSelectionResult() function to perform actions on onActivityResult().
        imageUtilityHelper.onSelectionResult(requestCode, resultCode, data);
        //Step 7. Call deleteLocalImage() function to delete temporary/local image. (optional)
        imageUtilityHelper.deleteLocalImage();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //TODO: Function that requires permission
                getImageChooser();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    //Show permission explanation dialog...
                    Snackbar.make(findViewById(android.R.id.content), "Permission Required", Snackbar.LENGTH_LONG)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION_CODE);
                                }
                            })
                            .show();
                } else {
                    //Never ask again selected, or device policy prohibits the app from having that permission.
                    //So, disable that feature, or fall back to another situation...
                    //Open App Settings Page
                    Snackbar.make(findViewById(android.R.id.content), "You have denied this permission. Please allow this permission.", Snackbar.LENGTH_LONG)
                            .setAction("Settings", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intentSettings = new Intent();
                                    intentSettings.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    intentSettings.addCategory(Intent.CATEGORY_DEFAULT);
                                    intentSettings.setData(Uri.parse("package:" + mContext.getPackageName()));
                                    intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intentSettings.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    intentSettings.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                    mContext.startActivity(intentSettings);
                                }
                            }).show();
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
