package com.example.cancer.ascs.ModelClasses;
import com.google.gson.annotations.SerializedName;

public class UpdatesuccesfullyResponse{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String name;
	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"UpdatesuccesfullyResponse{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' +
					"name = '" + name + '\'' +
			"}";
		}
}