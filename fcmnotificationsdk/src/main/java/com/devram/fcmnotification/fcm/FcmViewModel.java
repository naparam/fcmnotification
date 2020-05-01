package com.devram.fcmnotification.fcm;


import androidx.core.app.NotificationManagerCompat;

import com.devram.fcmnotification.FcmNotificationSDK;
import com.devram.fcmnotification.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

public class FcmViewModel {

    private FirebaseInstanceId firebaseInstanceId;
    private FirebaseApp firebaseApp;

    /**
     * Register Device for Fcm
     * if sender id is null then retrun value to observer as a false else return a true
     */
    public void getFcmRegistereToken()  {
        firebaseApp = FirebaseApp.getInstance();
        String senderId = FcmNotificationSDK.getInstance().getContext().getString(R.string.fcmtoken_sender_id);
        if (senderId == null){
            FcmNotificationSDK.getInstance().getObserver().getSubscriptionStatus(false);
        }else {
            firebaseInstanceId = FirebaseInstanceId.getInstance(firebaseApp);
            firebaseInstanceId.getToken();
            FcmNotificationSDK.getInstance().getObserver().getSubscriptionStatus(true);
        }


    }

    /**
     * checking if app  has permission to show notification or not
     * @return : True ot False based on permission
     */
    private boolean isNotificationEnable(){
        return NotificationManagerCompat.from(FcmNotificationSDK.getInstance().getContext()).areNotificationsEnabled();

    }

    /**
     *  showNotificationView() method is use to check if app has permission to show notification
     *      if Notification permission  ==  FALSE then it will not show notification
     *       if Notification permission  ==  TRUE then it will show notification
     * @param title : Notification Title
     * @param message : Notification Message
     * @param refId : ref Id
     */
    public void showNotificationView(String title, String message,String refId){
        if (isNotificationEnable()){
            FcmNotificationManager.showNotification(FcmNotificationSDK.getInstance().getContext(),
                    FcmNotificationSDK.getInstance().getShowClass(),title,message,refId);
        }else {
            FcmNotificationSDK.getInstance().getObserver().getPermissionStatus(isNotificationEnable());
        }
    }

}
