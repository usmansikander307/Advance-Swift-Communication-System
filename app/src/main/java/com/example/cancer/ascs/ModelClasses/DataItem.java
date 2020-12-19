package com.example.cancer.ascs.ModelClasses;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("T_name")
	private String tName;

	@SerializedName("status")
	private String status;

	@SerializedName("T_id")
	private String TeacherID;

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public void setTName(String tName){
		this.tName = tName;
	}

	public String getTName(){
		return tName;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"t_name = '" + tName + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}