package com.bean;


public class LightSensorBean {

	private long dateTime;
	private float luxValue;
	
	public long getDateTime() {
		return dateTime;
	}
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
	public float getLuxValue() {
		return luxValue;
	}
	public void setLuxValue(float luxValue) {
		this.luxValue = luxValue;
	}
	@Override
	public String toString()
	{
		return new StringBuffer().append(dateTime).
				append(" ").append(luxValue).toString();

	}
	public LightSensorBean(final long dateTime,final float luxValue)
	{
		this.dateTime=dateTime;
		this.luxValue=luxValue;
	}
}
