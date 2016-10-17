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

        //Calling function to show splash screen
        int mPrefferedWay = 0;
        switch (mPrefferedWay) {
            case 0:
                showSplashUsingThread();
                break;
            case 1:
                showSplashUsingRunnable();
                break;
            case 2:
                new SplashUsingAsyncTask().execute();
                break;
        }

    }

    /**
     * <b>private void showSplashUsingThread()</b>
     * <p>This function is used to show splash screen using Thread</p>
     * <p1>Created By - Rohitss</p1>
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
     * <b>private void showSplashUsingRunnable()</b>
     * <p>This function is used to show splash screen using Runnable</p>
     * <p1>Created By - Rohitss</p1>
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

    private class SplashUsingAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }
}
