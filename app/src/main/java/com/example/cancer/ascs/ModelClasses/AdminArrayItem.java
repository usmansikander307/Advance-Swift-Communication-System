package com.example.cancer.ascs.ModelClasses;


import com.google.gson.annotations.SerializedName;

public class AdminArrayItem{

	@SerializedName("Adm_name")
	private String admName;

	@SerializedName("Adm_id")
	private int admId;

	public void setAdmName(String admName){
		this.admName = admName;
	}

	public String getAdmName(){
		return admName;
	}

	public void setAdmId(int admId){
		this.admId = admId;
	}

	public int getAdmId(){
		return admId;
	}

	@Override
 	public String toString(){
		return 
			"AdminArrayItem{" + 
			"adm_name = '" + admName + '\'' + 
			",adm_id = '" + admId + '\'' + 
			"}";
		}
}