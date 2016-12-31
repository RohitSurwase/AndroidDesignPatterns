package com.rohitss.splashscreen;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private int SPLSH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /**
         * There are common 3 way to achive flash screen
         * 1. using thread
         * 2. using Runnable Handler
         * 3. using AsyncTask  (Use AsyncTask if you need to request api)
         */

        //Calling function to show splash screen
        int prefferedWay = 0;
        switch (prefferedWay) {
            case 0:
                showSplashUsingThread();
                break;
            case 1:
                showSplashUsingRunnable(); //comment onStop method
                break;
            case 2:
                new SplashUsingAsyncTask().execute(); //comment onStop method
                break;
        }

    }

    /**
     * This function is used to show splash screen using Thread
     * Created By - Rohitss
     */
    private void showSplashUsingThread() {
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    //Set splash screen time here in multiple of 1000
                    sleep(SPLSH_TIME);
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

    //If you are using thread then only use following function
    @Override
    protected void onStop() {
        super.onStop();
        //finish this activity as we moves to next activity
        finish();
    }

    /**
     * This function is used to show splash screen using Runnable
     * Created By - Rohitss
     */
    private void showSplashUsingRunnable() {
        //postDelayed(Runnable r, long delayMillis)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMain = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentMain);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                //finish this activity as we moves to next activity
                finish();
            }
        }, SPLSH_TIME);
    }

    private class SplashUsingAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //api calling function here
            return null;
        }
    }
}
