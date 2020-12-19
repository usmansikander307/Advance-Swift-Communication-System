package com.example.cancer.ascs.ModelClasses.Teacher;

import com.google.gson.annotations.SerializedName;

public class StudentsItem{

	@SerializedName("pass")
	private String pass;

	@SerializedName("name")
	private String name;

	@SerializedName("qual")
	private String qual;

	@SerializedName("id")
	private String id;

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

	public void setQual(String qual){
		this.qual = qual;
	}

	public String getQual(){
		return qual;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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
			"StudentsItem{" + 
			"pass = '" + pass + '\'' + 
			",name = '" + name + '\'' + 
			",qual = '" + qual + '\'' + 
			",id = '" + id + '\'' + 
			",cont = '" + cont + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}