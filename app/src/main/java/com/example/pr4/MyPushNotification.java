package com.example.pr4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyPushNotification {
    private static final String CHANNEL_ID = "Основной Канал";
    private static final String CHANNEL_DESCRIPTION = "Это основной канал!";
    private static final int NOTIFY_ID = 123;

    private final NotificationManager notificationManager;
    private final Context context;

    public MyPushNotification(Context context, NotificationManager manager) {
        this.notificationManager = manager;
        this.context = context;
        createNotificationChannel();
    }

    public void sendNotify(String title, String text) {
        sendNotify(title, text, NOTIFY_ID);
    }

    public void sendNotify(String title, String text, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (context.checkSelfPermission("android.permission.POST_NOTIFICATIONS")
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_baseline_blender_24)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(id, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, importance);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }
}