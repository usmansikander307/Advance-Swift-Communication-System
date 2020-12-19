package com.example.cancer.ascs.ModelClasses.DataOperator;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FeedbackResponse{

	@SerializedName("success")
	private int success;

	@SerializedName("feedbacks")
	private List<FeedbacksItem> feedbacks;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setFeedbacks(List<FeedbacksItem> feedbacks){
		this.feedbacks = feedbacks;
	}

	public List<FeedbacksItem> getFeedbacks(){
		return feedbacks;
	}

	@Override
 	public String toString(){
		return 
			"FeedbackResponse{" + 
			"success = '" + success + '\'' + 
			",feedbacks = '" + feedbacks + '\'' + 
			"}";
		}
}