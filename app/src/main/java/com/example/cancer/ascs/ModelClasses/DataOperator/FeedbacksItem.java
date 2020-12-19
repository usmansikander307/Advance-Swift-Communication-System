package com.example.cancer.ascs.ModelClasses.DataOperator;

import com.google.gson.annotations.SerializedName;

public class FeedbacksItem{

	@SerializedName("q1")
	private String q1;

	@SerializedName("date")
	private String date;

	@SerializedName("q2")
	private String q2;

	@SerializedName("arid")
	private String arid;

	@SerializedName("q3")
	private String q3;

	@SerializedName("q4")
	private String q4;

	@SerializedName("q5")
	private String q5;

	@SerializedName("q6")
	private String q6;

	@SerializedName("clas")
	private String clas;

	@SerializedName("id")
	private String id;

	public void setQ1(String q1){
		this.q1 = q1;
	}

	public String getQ1(){
		return q1;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setQ2(String q2){
		this.q2 = q2;
	}

	public String getQ2(){
		return q2;
	}

	public void setArid(String arid){
		this.arid = arid;
	}

	public String getArid(){
		return arid;
	}

	public void setQ3(String q3){
		this.q3 = q3;
	}

	public String getQ3(){
		return q3;
	}

	public void setQ4(String q4){
		this.q4 = q4;
	}

	public String getQ4(){
		return q4;
	}

	public void setQ5(String q5){
		this.q5 = q5;
	}

	public String getQ5(){
		return q5;
	}

	public void setQ6(String q6){
		this.q6 = q6;
	}

	public String getQ6(){
		return q6;
	}

	public void setClas(String clas){
		this.clas = clas;
	}

	public String getClas(){
		return clas;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"FeedbacksItem{" + 
			"q1 = '" + q1 + '\'' + 
			",date = '" + date + '\'' + 
			",q2 = '" + q2 + '\'' + 
			",arid = '" + arid + '\'' + 
			",q3 = '" + q3 + '\'' + 
			",q4 = '" + q4 + '\'' + 
			",q5 = '" + q5 + '\'' + 
			",q6 = '" + q6 + '\'' + 
			",clas = '" + clas + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}