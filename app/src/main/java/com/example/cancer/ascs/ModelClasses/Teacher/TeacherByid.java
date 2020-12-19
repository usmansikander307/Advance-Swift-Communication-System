package com.example.cancer.ascs.ModelClasses.Teacher;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class TeacherByid{

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
			"TeacherByid{" + 
			"student = '" + student + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}