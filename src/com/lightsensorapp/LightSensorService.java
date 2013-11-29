package com.lightsensorapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.bean.LightSensorBean;
import com.helper.LightSensorHelperImpl;
import com.helper.LightSensorHelperInterface;

public class LightSensorService extends Service implements SensorEventListener{

	private static final String TAG = "LightSensorService";
	private float lightData=0;
	private SensorManager mSensorManager;
	private Sensor mSensor;
	private LightSensorHelperInterface lightSensorHelperInterface = new LightSensorHelperImpl();


	@Override
	public void onCreate() 
	{
		Log.i(TAG, "Service onCreate");
		  mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		  mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
	      mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_FASTEST);
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{

		Log.i(TAG, "Service onStartCommand");
		lightSensorHelperInterface.storeLocally(new LightSensorBean(System.currentTimeMillis(), lightData));
		Toast.makeText(this, "Service Start Command", Toast.LENGTH_LONG).show();
		return Service.START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "Service onBind");
		return null;
	}

	@Override
	public void onDestroy()
	{
		Log.i(TAG, "Service onDestroy");
		mSensorManager.unregisterListener(this);
		Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event)
	{
		if(event.sensor.getType()==Sensor.TYPE_LIGHT)
		{
			lightData=event.values[0];
		}
	}

}
