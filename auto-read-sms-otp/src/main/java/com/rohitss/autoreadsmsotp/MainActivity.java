package com.rohitss.autoreadsmsotp;

import android.Manifest;
import android.content.ComponentName;
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
import android.widget.Toast;

/**
 * This is the Activity class where we want to receive the sms/otp.
 * Created by rohitss.
 */
public class MainActivity extends AppCompatActivity {
    private static final int READ_SMS_PERMISSION_CODE = 101;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
//Request Permission for SMS
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            //Permission is not allowed so request permission.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, READ_SMS_PERMISSION_CODE);
        } else {
            //Permission is allowed so proceed.
            autoReadSmsOtp();
        }
    }

    /**
     * This is the function where we can read received SMS.
     */
    private void autoReadSmsOtp() {
        SmsReceiver.isAutoReadOtp = true;
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                Toast.makeText(getBaseContext(), messageText, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Enable our broadcast receiver.
        ComponentName receiver = new ComponentName(mContext, SmsReceiver.class);
        PackageManager pm = mContext.getPackageManager();
        pm.setComponentEnabledSetting(receiver, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Disable our broadcast receiver.
        ComponentName receiver = new ComponentName(mContext, SmsReceiver.class);
        PackageManager pm = mContext.getPackageManager();
        pm.setComponentEnabledSetting(receiver, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }

    /**
     * This function is used check if permission is allowed or not.
     *
     * @param requestCode  requestCode
     * @param permissions  permissions
     * @param grantResults grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //TODO: Permissions Received, auto read otp functionality will work now
                autoReadSmsOtp();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
                    //Show permission explanation dialog...
                    Snackbar.make(findViewById(android.R.id.content), "Permission required to receive OTP.", Snackbar.LENGTH_LONG)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, READ_SMS_PERMISSION_CODE);
                                }
                            })
                            .setActionTextColor(ContextCompat.getColor(mContext, R.color.colorAccent))
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
                            })
                            .setActionTextColor(ContextCompat.getColor(mContext, R.color.colorAccent))
                            .show();
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}

