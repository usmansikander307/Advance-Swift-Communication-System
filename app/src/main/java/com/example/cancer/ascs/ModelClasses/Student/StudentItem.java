package com.example.cancer.ascs.ModelClasses.Student;


import com.google.gson.annotations.SerializedName;


public class StudentItem{

	@SerializedName("arid")
	private String arid;

	@SerializedName("pass")
	private String pass;

	@SerializedName("name")
	private String name;

	@SerializedName("pid")
	private String pid;

	@SerializedName("cont")
	private String cont;

	@SerializedName("email")
	private String email;

	public void setArid(String arid){
		this.arid = arid;
	}

	public String getArid(){
		return arid;
	}

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
			"arid = '" + arid + '\'' + 
			",pass = '" + pass + '\'' + 
			",name = '" + name + '\'' + 
			",pid = '" + pid + '\'' + 
			",cont = '" + cont + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}