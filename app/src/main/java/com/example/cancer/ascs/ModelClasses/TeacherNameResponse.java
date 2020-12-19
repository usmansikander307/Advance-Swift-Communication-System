package com.example.cancer.ascs.ModelClasses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TeacherNameResponse{

	@SerializedName("TeacherArray")
	private List<TeacherArrayItem> teacherArray;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setTeacherArray(List<TeacherArrayItem> teacherArray){
		this.teacherArray = teacherArray;
	}

	public List<TeacherArrayItem> getTeacherArray(){
		return teacherArray;
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
			"TeacherNameResponse{" + 
			"teacherArray = '" + teacherArray + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}