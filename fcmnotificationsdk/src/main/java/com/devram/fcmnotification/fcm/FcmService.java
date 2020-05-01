package com.devram.fcmnotification.fcm;

import androidx.annotation.NonNull;
import com.devram.fcmnotification.FcmNotificationSDK;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

/**
 * FcmService class is used to refresh token and recive message from console
 */
public class FcmService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        storeToken(token);
    }

    /**
     * store token in data manager to use for next time
     * @param token : new token
     */
    private void storeToken(String token) {
        FcmNotificationSDK.getInstance().getObserver().getSubscriptionToken(token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Map<String, String> messagePayload = remoteMessage.getData();
        FcmTokenModule.createViewModel().showNotificationView(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody()
                ,messagePayload.get(FcmConstants.FCM_REFERENCE_ID));
    }


}
