package com.devram.fcmnotificationdemo;

import android.app.Application;
import com.devram.fcmnotification.FcmNotificationSDK;

public class FcmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FcmNotificationSDK.getInstance().init(this);
        FcmNotificationSDK.getInstance().setShowClass(MainActivity.class);
    }

}
