package com.kumar.jagadeesh.reminder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class MyReceiver extends BroadcastReceiver {

    public static final String reminderKEY="reminder kay";
    String tt;
    String CHANNEL_ID = "my_channel_01";
    SharedPreferences sharedPreferences;
    int notifyID = 1;
    Intent intent;

    @Override
    public void onReceive(Context context, Intent intent) {
        //sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        //SharedPreferences.Editor editor=sharedPreferences.edit();
        //if (sharedPreferences.contains(reminderKEY)){
        //    tt=sharedPreferences.getString(reminderKEY,"");
        //}
        Intent resultintent=new Intent(context,Main7Activity.class);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        //  CharSequence name = getString(R.string.channel_name);
       // NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
        //intent=new Intent(context,Main7Activity.class);
        resultintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,(int) Calendar.getInstance().getTimeInMillis(),resultintent,0);
        NotificationCompat.InboxStyle inboxStyle=new  NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Reminder");
        inboxStyle.addLine("You Have reminder");
        NotificationCompat.Builder builder=(NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.rem)
                .setContentTitle("You Have a Reminder")
                .setContentText(tt).setStyle(inboxStyle)
                .setChannelId(CHANNEL_ID)
                //.setWhen()
                .addAction(R.mipmap.ic_launcher,"Show",pendingIntent);
        NotificationManager notificationManager=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
       // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         //   notificationManager.createNotificationChannel(mChannel);
       // }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            /* Create or update. */
            NotificationChannel channel = new NotificationChannel("my_channel_01",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(notifyID, builder.build());
    }
}

