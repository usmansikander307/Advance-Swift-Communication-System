package com.example.cancer.ascs.ModelClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class AdminArray{

	@SerializedName("AdminArray")
	private List<AdminArrayItem> adminArray;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setAdminArray(List<AdminArrayItem> adminArray){
		this.adminArray = adminArray;
	}

	public List<AdminArrayItem> getAdminArray(){
		return adminArray;
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
			"AdminArray{" + 
			"adminArray = '" + adminArray + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}