package com.example.cancer.ascs.ModelClasses.DataOperator;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RoomResponse{

	@SerializedName("success")
	private int success;

	@SerializedName("room")
	private List<RoomItem> room;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setRoom(List<RoomItem> room){
		this.room = room;
	}

	public List<RoomItem> getRoom(){
		return room;
	}

	@Override
 	public String toString(){
		return 
			"RoomResponse{" + 
			"success = '" + success + '\'' + 
			",room = '" + room + '\'' + 
			"}";
		}
}