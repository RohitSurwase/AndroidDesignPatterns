package com.rohitss.autoreadsmsotp;

/**
 * This is the Interface to listen to received sms.
 * Created by rohitss.
 */
public interface SmsListener {
    void messageReceived(String strMessageBody);
}
