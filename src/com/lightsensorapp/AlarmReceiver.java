package com.lightsensorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{
	
	 @Override
     public void onReceive(Context context, Intent intent)
     {
		 Intent intent2= new Intent(context,LightSensorService.class);
		 context.startService(intent2);
         Toast.makeText(context, "Alarm Triggered ", Toast.LENGTH_LONG).show();
      }

}
