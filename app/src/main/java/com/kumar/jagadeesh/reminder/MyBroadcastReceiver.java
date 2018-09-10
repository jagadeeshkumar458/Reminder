package com.kumar.jagadeesh.reminder;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

class MyBroadcastReceiver extends BroadcastReceiver {
    public static final String reminderKEY="reminder kay";
    String tt;
    SharedPreferences sharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        // sharedPreferences=getSharedPreferences(getString(R.string.my_preferences),MODE_PRIVATE);
        // SharedPreferences.Editor editor=sharedPreferences.edit();
        if (sharedPreferences.contains(reminderKEY)){
            tt=sharedPreferences.getString(reminderKEY,"");
        }
        Intent resultintent=new Intent(context,MyBroadcastReceiver.class);
        resultintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,(int) Calendar.getInstance().getTimeInMillis(),resultintent,0);
        NotificationCompat.InboxStyle inboxStyle=new  NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Reminder");
        inboxStyle.addLine(tt);
        NotificationCompat.Builder builder=(NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("You Have a Reminder")
                .setContentText(tt).setStyle(inboxStyle)
                //.setWhen()
                .addAction(R.mipmap.ic_launcher,"Show",pendingIntent);
        NotificationManager notificationManager=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
