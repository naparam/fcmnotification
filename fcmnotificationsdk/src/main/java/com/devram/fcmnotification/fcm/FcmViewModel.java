package com.devram.fcmnotification.fcm;


import androidx.core.app.NotificationManagerCompat;

import com.devram.fcmnotification.FcmNotificationSDK;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

public class FcmViewModel {

    private FirebaseInstanceId firebaseInstanceId;

    public void getFcmRegistereToken()  {
        firebaseInstanceId = FirebaseInstanceId.getInstance(FirebaseApp.getInstance());
        firebaseInstanceId.getToken();
    }
    public boolean isNotificationEnable(){
        return NotificationManagerCompat.from(FcmNotificationSDK.getInstance().getContext()).areNotificationsEnabled();

    }

    public void showNotificationView(String title, String message,String refId){
        if (isNotificationEnable()){
            FcmNotificationManager.showNotification(FcmNotificationSDK.getInstance().getContext(),
                    FcmNotificationSDK.getInstance().getShowClass(),title,message,refId);
        }else {
            FcmNotificationSDK.getInstance().getObserver().getPermissionStatus(isNotificationEnable());
        }
    }

}
