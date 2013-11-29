package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;

public class FileUtils {

	private final static String FILENAME = "lightSensor.txt";

	public static void writeLocally(final String lightData)
	{
		File lightSensorData = new File(Environment.getExternalStorageDirectory().getPath(), FILENAME);
		//	   File lightSensorData = new File(dir+"/lightSensor.file");

		if (!lightSensorData.exists())
		{
			try
			{
				lightSensorData.createNewFile();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			BufferedWriter buf = new BufferedWriter(new FileWriter(lightSensorData, true)); 
			buf.append(lightData);
			buf.newLine();
			buf.flush();
			buf.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
