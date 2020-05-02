package com.devram.fcmnotificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.devram.fcmnotification.FcmNotificationSDK;
import com.devram.fcmnotification.fcm.FcmObserver;
import com.devram.fcmnotification.fcm.FcmViewModel;

/**
 * MainActivity is use for Demo purpose
 */
public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    private FcmViewModel fcmViewModel;
    private String fcmToken;

    private FcmObserver observer = new FcmObserver() {
        @Override
        public void getSubscriptionToken(String token) {
            DataManagerFcm.getInstance(getApplicationContext()).storeFcmToken(token);
        }

        @Override
        public void getSubscriptionStatus(boolean isFcmRegistered) {
            Log.e(TAG,"is FcmRegistered "+isFcmRegistered);
        }

        @Override
        public void getPermissionStatus(boolean isPermission) {
            Log.e(TAG,"is Permission "+isPermission);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fcmViewModel = new FcmViewModel();
        FcmNotificationSDK.getInstance().setObserver(observer);
        fcmToken = DataManagerFcm.getInstance(getApplicationContext()).getToken();
        if (fcmToken == null) {
            fcmViewModel.getFcmRegistereToken();
        }

    }
}
