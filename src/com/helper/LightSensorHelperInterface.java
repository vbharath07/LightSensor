package com.helper;

import com.bean.LightSensorBean;

public interface LightSensorHelperInterface {

	void storeLocally(final LightSensorBean lightSensorBean);
	void storeDropbox(final LightSensorBean lightSensorBean);
}
