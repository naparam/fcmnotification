package com.devram.fcmnotification.fcm;

import androidx.annotation.NonNull;

public class FcmTokenModule {

    FcmTokenModule(){
        //intentionally left blank
    }

    @NonNull
    public static FcmViewModel createViewModel() {
        return new FcmViewModel();
    }
}
