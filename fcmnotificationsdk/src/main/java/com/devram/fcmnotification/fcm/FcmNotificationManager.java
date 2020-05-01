package com.devram.fcmnotification.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.devram.fcmnotification.R;

/**
 * FcmNotificationManager class is used to create Notification builder
 */
public class FcmNotificationManager {
    private FcmNotificationManager() {
        //intentionally left blank
    }

    public static void showNotification(Context context, Class<?> showClass, String title, String message, String referenceId) {
        Intent intent = new Intent(context, showClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(FcmConstants.FCM_REFERENCE_ID, referenceId);
        prepareAndShowNotification(context, intent, title, message);
    }

    public static void prepareAndShowNotification(Context context, Intent intent, String title, String message) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);


        String channelId = context.getString(R.string.fcm_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle(title);
        bigTextStyle.bigText(message);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(R.drawable.notification_general)
                        .setContentTitle(title)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.notification_general))
                        .setContentText(message)
                        .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                        .setAutoCancel(true)
                        .setStyle(bigTextStyle)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    context.getString(R.string.fcm_channel_title),
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        int notificationId = (int) SystemClock.uptimeMillis();
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
