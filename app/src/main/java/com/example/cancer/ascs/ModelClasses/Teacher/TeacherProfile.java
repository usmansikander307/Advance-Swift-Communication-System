package com.example.cancer.ascs.ModelClasses.Teacher;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class TeacherProfile{

	@SerializedName("success")
	private int success;

	@SerializedName("students")
	private List<StudentsItem> students;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setStudents(List<StudentsItem> students){
		this.students = students;
	}

	public List<StudentsItem> getStudents(){
		return students;
	}

	@Override
 	public String toString(){
		return 
			"TeacherProfile{" + 
			"success = '" + success + '\'' + 
			",students = '" + students + '\'' + 
			"}";
		}
}