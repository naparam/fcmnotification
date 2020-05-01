package com.devram.fcmnotificationdemo;

import android.content.Context;
import android.content.SharedPreferences;

import com.devram.fcmnotification.fcm.FcmConstants;

/**
 * save the fcm token locally for use next time when app is launch again
 */
public class DataManagerFcm {
    private static Context mCtx;
    private static DataManagerFcm mInstance;

    private DataManagerFcm(Context context){
        mCtx = context;
    }

    public static synchronized DataManagerFcm getInstance(Context context){
        if (mInstance == null)
            mInstance = new DataManagerFcm(context);
        return mInstance;
    }

    public boolean storeFcmToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(FcmConstants.SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FcmConstants.KEY_ACCESS_TOKEN,token);
        editor.apply();
        return true;
    }
    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(FcmConstants.SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(FcmConstants.KEY_ACCESS_TOKEN,null);
    }
}
