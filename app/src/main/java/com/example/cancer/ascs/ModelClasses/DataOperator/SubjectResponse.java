package com.example.cancer.ascs.ModelClasses.DataOperator;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubjectResponse{

	@SerializedName("subject")
	private List<SubjectItem> subject;

	@SerializedName("success")
	private int success;

	public void setSubject(List<SubjectItem> subject){
		this.subject = subject;
	}

	public List<SubjectItem> getSubject(){
		return subject;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"SubjectResponse{" + 
			"subject = '" + subject + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}