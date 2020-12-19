package com.example.cancer.ascs.ModelClasses;


import com.google.gson.annotations.SerializedName;


public class NotificationArrayItem{

	@SerializedName("A_name")
	private String aName;

	@SerializedName("Nt_id")
	private int ntId;

	@SerializedName("Nt_date")
	private String ntDate;

	@SerializedName("Nt_body")
	private String ntBody;

	public void setAName(String aName){
		this.aName = aName;
	}

	public String getAName(){
		return aName;
	}

	public void setNtId(int ntId){
		this.ntId = ntId;
	}

	public int getNtId(){
		return ntId;
	}

	public void setNtDate(String ntDate){
		this.ntDate = ntDate;
	}

	public String getNtDate(){
		return ntDate;
	}

	public void setNtBody(String ntBody){
		this.ntBody = ntBody;
	}

	public String getNtBody(){
		return ntBody;
	}

	@Override
 	public String toString(){
		return 
			"NotificationArrayItem{" + 
			"a_name = '" + aName + '\'' + 
			",nt_id = '" + ntId + '\'' + 
			",nt_date = '" + ntDate + '\'' + 
			",nt_body = '" + ntBody + '\'' + 
			"}";
		}
}