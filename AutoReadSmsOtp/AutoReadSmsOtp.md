Auto Read SMS or OTP  with runtime-permission

* Steps:
 * 1. Add Permissions to manifest
 * * <uses-permission android:name="android.permission.READ_SMS" />
 * * <uses-permission android:name="android.permission.RECEIVE_SMS" />
 * <p>
 * 2. Register our broadcast listener in manifest
 * * <receiver
 * * android:name=".SmsReceiver"
 * * android:permission="android.permission.BROADCAST_SMS">
 * * <intent-filter>
 * * <action android:name="android.provider.Telephony.SMS_RECEIVED" />
 * * </intent-filter>
 * * </receiver>
 * <p>
 * 3. Add two classes to your project.
 * * SmsListener.class
 * * SmsReceiver.class
 **  <p>
 *
 * 4. In your MainActivity.class or activity where you want to receive sms/otp, add the existing code
 * * (You can find the code in MainActivity.class file i.e. same file)
 * *
 *
 * Note: In SmsReceiver.class there is a constant which is used to distinguish all sms senders from our sender
 * Change this constant according to your project
 * * private static final String SMS_SENDER_NAME = "12345";
