package com.kumar.jagadeesh.reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomReceiver extends BroadcastReceiver {

   // @Override
   // public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");

   // }
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        switch (intentAction){
            case Intent.ACTION_POWER_CONNECTED:
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                break;
        }
    }
}
