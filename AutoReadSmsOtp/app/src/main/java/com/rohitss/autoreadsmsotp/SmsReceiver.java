package com.rohitss.autoreadsmsotp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * This class is used to Auto Read SMS Received
 * Created by Rohit.
 */
public class SmsReceiver extends BroadcastReceiver {
    private static final String SMS_SENDER_NAME = "12345";
    private static SmsListener mListener;
    public static boolean isAutoReadOtp = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages = null;
        String strMessageSender;
        String strMessageBody = "";
        if (myBundle != null) {
            Object[] pdus = (Object[]) myBundle.get("pdus");
            String format = myBundle.getString("format");
            if (pdus != null) {
                messages = new SmsMessage[pdus.length];
            }
            if (messages != null) {
                for (int i = 0; i < messages.length; i++) {

                    /**
                     * "createFromPdu" with extra parameter "format" was introduced for Android Marshmallow to support "3gpp"
                     * for GSM/UMTS/LTE messages in 3GPP format or "3gpp2" for CDMA/LTE messages in 3GPP2 format.
                     */

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    }
                    strMessageSender = messages[i].getDisplayOriginatingAddress();
                    //Message Sender Name
                    if (strMessageSender.equalsIgnoreCase(SMS_SENDER_NAME)) {
                        //Whole message text. Extract OTP from strMessageBody
                        strMessageBody = messages[i].getMessageBody();
                    }
                }
            }
            //Pass the text to listener interface.
            if (isAutoReadOtp) {
                mListener.messageReceived(strMessageBody);
            }
        }
    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}

////////////////////////
/*
//TODO: Steps/Helpful code

//TODO: Add this class (public class SmsReceiver extends BroadcastReceiver) to your project

//TODO: In Manifest Register Receiver -
<application
//Other Activities
        <receiver
            android:name="utils.SmsReceiver"
            android:permission="android.permission.BROADCAST_SMS">
            <intent-filter>
                <action android:name="android.provider.Telephony.SMS_RECEIVED" />
            </intent-filter>
        </receiver>
</application>


//TODO: Create this interface class
public interface SmsListener {
    void messageReceived(String messageText);
}

//TODO: In Activity/Fragment where you want to listen/receive/autoRead SMS

 //TODO: 1. Enable Receiver - onCreate of Activity
 ComponentName receiver = new ComponentName(mContext, SmsReceiver.class);
        PackageManager pm = mContext.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);


 //TODO: 2. Disable Receiver - onPause of Activity
 ComponentName receiver = new ComponentName(mContext, SmsReceiver.class);
        PackageManager pm = mContext.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);


//TODO: 3. Function to get messageText
SmsReceiver.isAutoReadOtp = true;
        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                Toast.makeText(getBaseContext(), messageText, Toast.LENGTH_LONG).show();
            }
        });

*/
////////////////////////
