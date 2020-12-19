package com.example.cancer.ascs.ModelClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class StudentArray{

	@SerializedName("StudentArray")
	private List<StudentArrayItem> studentArray;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setStudentArray(List<StudentArrayItem> studentArray){
		this.studentArray = studentArray;
	}

	public List<StudentArrayItem> getStudentArray(){
		return studentArray;
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
			"StudentArray{" + 
			"studentArray = '" + studentArray + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}