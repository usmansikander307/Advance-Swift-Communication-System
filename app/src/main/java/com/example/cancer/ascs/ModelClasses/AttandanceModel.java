package com.example.cancer.ascs.ModelClasses;

import com.google.gson.annotations.SerializedName;

public class AttandanceModel{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public boolean isError(){
		return error;
	}

	public String getMessage(){
		return message;
	}

}