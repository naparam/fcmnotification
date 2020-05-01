package com.devram.fcmnotification.fcm;

import androidx.annotation.NonNull;
import com.devram.fcmnotification.FcmNotificationSDK;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

public class FcmService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        FcmNotificationSDK.getInstance().getObserver().getSubscriptionToken(token);
        FcmNotificationSDK.getInstance().getObserver().getSubscriptionStatus(true);
    }
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Map<String, String> messagePayload = remoteMessage.getData();
        FcmTokenModule.createViewModel().showNotificationView(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody()
                ,messagePayload.get(FcmConstants.FCM_REFERENCE_ID));
    }


}
