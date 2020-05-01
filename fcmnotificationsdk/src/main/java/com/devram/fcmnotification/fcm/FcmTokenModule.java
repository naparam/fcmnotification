package com.devram.fcmnotification.fcm;

import androidx.annotation.NonNull;

/**
 * create viewmodole instance
 */
public class FcmTokenModule {

    FcmTokenModule(){
        //intentionally left blank
    }

    @NonNull
    public static FcmViewModel createViewModel() {
        return new FcmViewModel();
    }
}
