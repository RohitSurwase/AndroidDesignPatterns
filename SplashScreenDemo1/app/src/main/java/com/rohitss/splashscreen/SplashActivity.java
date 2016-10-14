package com.rohitss.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Calling function to show splash screen
        showSplashScreen();
    }

    /**
     * <b>private void showSplashScreen()</b>
     * <p>This function is used to show splash screen</p>
     * <p1>Created By - Rohitss</p1>
     */
    private void showSplashScreen() {
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    //Set splash screen time here in multiple of 1000
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intentMain = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intentMain);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        };
        splashThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //finish this activity as we moves to next activity
        finish();
    }
}
