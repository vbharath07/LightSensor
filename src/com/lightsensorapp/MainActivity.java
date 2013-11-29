package com.lightsensorapp;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

	private Button startButton ;
	private Button stopButton ;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.startButton);
		stopButton = (Button)findViewById(R.id.stopButton);
		bindHandlers();
	}

	private void bindHandlers() 
	{
		startButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				scheduleAlarm();
			}
		});

		stopButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancelAlarm();
			}
		});
	}

	public void scheduleAlarm()
	{
		Long time = new GregorianCalendar().getTimeInMillis()+15*1000;
		Intent intentAlarm = new Intent(this, AlarmReceiver.class);
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,time, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, new GregorianCalendar().getTimeInMillis(),  20*1000, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT) );
		Toast.makeText(this, "Started Logging", Toast.LENGTH_LONG).show();

	}

	public void  cancelAlarm()
	{
		Intent intentAlarm = new Intent(this, AlarmReceiver.class);
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
		stopService(new Intent(this,LightSensorService.class));
	}
}