package com.devram.fcmnotification;

import android.content.Context;
import com.devram.fcmnotification.fcm.FcmObserver;

/**
 * FcmNotificationSDK is a singleton class to init a FCMNotification Sdk
 */
public class FcmNotificationSDK {

    private Context context;
    private Class<?> showClass;
    private static FcmNotificationSDK INSTANCE = null;
    private FcmObserver observer;

    public void init(Context context) {
        setContext(context);
    }

    public Context getContext() {
        return context;
    }

    public Class<?> getShowClass() {
        return showClass;
    }

    public void setShowClass(Class<?> showClass) {
        this.showClass = showClass;
    }

    public static FcmNotificationSDK getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FcmNotificationSDK();
        }
        return INSTANCE;
    }

    private void setContext(Context context) {
        this.context = context;
    }

    public FcmObserver getObserver(){
        return observer;
    }
    public void setObserver(FcmObserver observer){
        this.observer = observer;

    }

}
