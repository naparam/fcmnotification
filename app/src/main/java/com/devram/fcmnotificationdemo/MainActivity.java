package com.devram.fcmnotificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.devram.fcmnotification.FcmNotificationSDK;
import com.devram.fcmnotification.fcm.FcmObserver;
import com.devram.fcmnotification.fcm.FcmViewModel;

public class MainActivity extends AppCompatActivity {
    FcmViewModel fcmViewModel = new FcmViewModel();
    private String fcmToken = null;
    private FcmObserver observer = new FcmObserver() {
        @Override
        public void getSubscriptionToken(String token) {
            fcmToken =token;
            Log.e("MainActivity","TOKEN ==========>"+fcmToken);
        }

        @Override
        public void getSubscriptionStatus(boolean isFcmRegistered) {
            Log.e("MainActivity","FcmRegistered ==========>"+isFcmRegistered);
        }

        @Override
        public void getPermissionStatus(boolean isPermission) {
            Log.e("MainActivity","Permission ==========>"+isPermission);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FcmNotificationSDK.getInstance().setObserver(observer);
        fcmViewModel.getFcmRegistereToken();
        Log.e("MainActivity","TOKEN ==========>"+fcmToken);
    }
}
