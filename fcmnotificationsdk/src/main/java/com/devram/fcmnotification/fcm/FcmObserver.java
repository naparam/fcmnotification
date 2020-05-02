package com.devram.fcmnotification.fcm;

/**
 * FcmObserver interface is use to update token, device Registered
 * and permission of notification to demo app
 */
public interface FcmObserver {
    void getSubscriptionToken(String token);
    void getSubscriptionStatus(boolean isFcmRegistered);
    void getPermissionStatus(boolean isPermission);

}
