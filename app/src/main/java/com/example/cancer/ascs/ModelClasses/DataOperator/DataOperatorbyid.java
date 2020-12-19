package com.example.cancer.ascs.ModelClasses.DataOperator;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class DataOperatorbyid{

	@SerializedName("student")
	private List<StudentItem> student;

	@SerializedName("success")
	private int success;

	public void setStudent(List<StudentItem> student){
		this.student = student;
	}

	public List<StudentItem> getStudent(){
		return student;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"DataOperatorbyid{" + 
			"student = '" + student + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}