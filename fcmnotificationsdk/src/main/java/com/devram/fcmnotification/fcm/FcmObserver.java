package com.devram.fcmnotification.fcm;

/**
 * FcmObserver interface is use to update current data to Application
 */
public interface FcmObserver {
    void getSubscriptionToken(String token);
    void getSubscriptionStatus(boolean isFcmRegistered);
    void getPermissionStatus(boolean isPermission);

}
