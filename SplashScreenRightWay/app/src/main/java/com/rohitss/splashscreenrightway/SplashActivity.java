package com.rohitss.splashscreenrightway;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * This is activity class which will act as a flash screen.
 * This class dont have any view at all.
 * Created By rohitss.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView is not needed as we are showing splash screen using theme in styles.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Add 2 seconds pause for splash screen using handler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), SecondActivity.class));
            }
        }, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //finish splash screen activity.
        finish();
    }
}
