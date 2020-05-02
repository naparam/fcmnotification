package com.devram.fcmnotificationdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * save the fcm token locally for use next time when app is launch again
 */
public class DataManagerFcm {
    private static Context mCtx;
    private static DataManagerFcm mInstance;

    public static final String SHARED_PREF_NAME = "fcmsharedpref";
    public static final String KEY_ACCESS_TOKEN = "token";

    private DataManagerFcm(Context context){
        mCtx = context;
    }

    public static synchronized DataManagerFcm getInstance(Context context){
        if (mInstance == null)
            mInstance = new DataManagerFcm(context);
        return mInstance;
    }

    public boolean storeFcmToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN,token);
        editor.apply();
        return true;
    }
    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN,null);
    }
}
