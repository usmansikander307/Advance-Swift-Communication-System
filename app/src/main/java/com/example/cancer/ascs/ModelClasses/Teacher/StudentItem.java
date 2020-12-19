package com.example.cancer.ascs.ModelClasses.Teacher;

import com.google.gson.annotations.SerializedName;


public class StudentItem{

	@SerializedName("pass")
	private String pass;

	@SerializedName("name")
	private String name;

	@SerializedName("pid")
	private String pid;

	@SerializedName("qual")
	private String qual;

	@SerializedName("cont")
	private String cont;

	@SerializedName("email")
	private String email;

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getPass(){
		return pass;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return pid;
	}

	public void setQual(String qual){
		this.qual = qual;
	}

	public String getQual(){
		return qual;
	}

	public void setCont(String cont){
		this.cont = cont;
	}

	public String getCont(){
		return cont;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"StudentItem{" + 
			"pass = '" + pass + '\'' + 
			",name = '" + name + '\'' + 
			",pid = '" + pid + '\'' + 
			",qual = '" + qual + '\'' + 
			",cont = '" + cont + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}