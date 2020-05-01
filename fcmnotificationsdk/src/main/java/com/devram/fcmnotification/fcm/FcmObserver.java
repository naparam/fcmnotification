package com.devram.fcmnotification.fcm;

public interface FcmObserver {
    void getSubscriptionToken(String token);
    void getSubscriptionStatus(boolean isFcmRegistered);
    void getPermissionStatus(boolean isPermission);

}
