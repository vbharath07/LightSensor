package com.helper;

import com.bean.LightSensorBean;
import com.util.FileUtils;

public class LightSensorHelperImpl implements LightSensorHelperInterface{

	/*
	 * To the store light data  Locally
	 * */
	
	@Override
	public void storeLocally(LightSensorBean lightSensorBean) {
		FileUtils.writeLocally(lightSensorBean.getDateTime()+":"+lightSensorBean.getLuxValue());
	}
/*
 * DropBox Code Has to written
 * 
 * */
	@Override
	public void storeDropbox(LightSensorBean lightSensorBean) {
		// TODO Auto-generated method stub
		
	}

}
