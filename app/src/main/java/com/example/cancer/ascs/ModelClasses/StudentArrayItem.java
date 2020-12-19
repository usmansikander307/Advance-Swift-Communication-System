package com.example.cancer.ascs.ModelClasses;

import com.google.gson.annotations.SerializedName;


public class StudentArrayItem{

	@SerializedName("Std_name")
	private String stdName;

	@SerializedName("Std_id")
	private int stdId;

	@SerializedName("Std_pass")
	private String stdPass;

	@SerializedName("Std_email")
	private String stdEmail;

	@SerializedName("Std_arid")
	private String stdArid;

	@SerializedName("Std_cont")
	private String stdCont;

	public void setStdName(String stdName){
		this.stdName = stdName;
	}

	public String getStdName(){
		return stdName;
	}

	public void setStdId(int stdId){
		this.stdId = stdId;
	}

	public int getStdId(){
		return stdId;
	}

	public void setStdPass(String stdPass){
		this.stdPass = stdPass;
	}

	public String getStdPass(){
		return stdPass;
	}

	public void setStdEmail(String stdEmail){
		this.stdEmail = stdEmail;
	}

	public String getStdEmail(){
		return stdEmail;
	}

	public void setStdArid(String stdArid){
		this.stdArid = stdArid;
	}

	public String getStdArid(){
		return stdArid;
	}

	public void setStdCont(String stdCont){
		this.stdCont = stdCont;
	}

	public String getStdCont(){
		return stdCont;
	}

	@Override
 	public String toString(){
		return 
			"StudentArrayItem{" + 
			"std_name = '" + stdName + '\'' + 
			",std_id = '" + stdId + '\'' + 
			",std_pass = '" + stdPass + '\'' + 
			",std_email = '" + stdEmail + '\'' + 
			",std_arid = '" + stdArid + '\'' + 
			",std_cont = '" + stdCont + '\'' + 
			"}";
		}
}