package com.example.cancer.ascs.ModelClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ViewNotification<T>{

	@SerializedName("NotificationArray")
	private List<NotificationArrayItem> notificationArray;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setNotificationArray(List<NotificationArrayItem> notificationArray){
		this.notificationArray = notificationArray;
	}

	public List<NotificationArrayItem> getNotificationArray(){
		return notificationArray;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ViewNotification{" + 
			"notificationArray = '" + notificationArray + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}