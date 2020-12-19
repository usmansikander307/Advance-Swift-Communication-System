package com.example.cancer.ascs.ModelClasses;


import com.google.gson.annotations.SerializedName;


public class TeacherArrayItem{

	@SerializedName("T_id")
	private int tId;

	@SerializedName("T_name")
	private String tName;

	@SerializedName("T_pass")
	private String tPass;

	@SerializedName("T_email")
	private String tEmail;

	@SerializedName("T_cont")
	private String tCont;

	public void setTId(int tId){
		this.tId = tId;
	}

	public int getTId(){
		return tId;
	}

	public void setTName(String tName){
		this.tName = tName;
	}

	public String getTName(){
		return tName;
	}

	public void setTPass(String tPass){
		this.tPass = tPass;
	}

	public String getTPass(){
		return tPass;
	}

	public void setTEmail(String tEmail){
		this.tEmail = tEmail;
	}

	public String getTEmail(){
		return tEmail;
	}

	public void setTCont(String tCont){
		this.tCont = tCont;
	}

	public String getTCont(){
		return tCont;
	}

	@Override
 	public String toString(){
		return 
			"TeacherArrayItem{" + 
			"t_id = '" + tId + '\'' + 
			",t_name = '" + tName + '\'' + 
			",t_pass = '" + tPass + '\'' + 
			",t_email = '" + tEmail + '\'' + 
			",t_cont = '" + tCont + '\'' + 
			"}";
		}
}