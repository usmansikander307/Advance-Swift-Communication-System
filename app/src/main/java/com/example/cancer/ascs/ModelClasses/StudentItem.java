package com.example.cancer.ascs.ModelClasses;


import com.google.gson.annotations.SerializedName;

public class StudentItem{

	@SerializedName("sub1obt")
	private String sub1obt;

	@SerializedName("sub6")
	private String sub6;

	@SerializedName("sub4")
	private String sub4;

	@SerializedName("sub5")
	private String sub5;

	@SerializedName("sub2")
	private String sub2;

	@SerializedName("sub3")
	private String sub3;

	@SerializedName("shift")
	private String shift;

	@SerializedName("sub1")
	private String sub1;

	@SerializedName("Rid")
	private String rid;

	@SerializedName("name")
	private String name;

	@SerializedName("sub6obt")
	private String sub6obt;

	@SerializedName("sub4obt")
	private String sub4obt;

	@SerializedName("class")
	private String jsonMemberClass;

	@SerializedName("sub2obt")
	private String sub2obt;

	@SerializedName("sub5obt")
	private String sub5obt;

	@SerializedName("sub3obt")
	private String sub3obt;

	public void setSub1obt(String sub1obt){
		this.sub1obt = sub1obt;
	}

	public String getSub1obt(){
		return sub1obt;
	}

	public void setSub6(String sub6){
		this.sub6 = sub6;
	}

	public String getSub6(){
		return sub6;
	}

	public void setSub4(String sub4){
		this.sub4 = sub4;
	}

	public String getSub4(){
		return sub4;
	}

	public void setSub5(String sub5){
		this.sub5 = sub5;
	}

	public String getSub5(){
		return sub5;
	}

	public void setSub2(String sub2){
		this.sub2 = sub2;
	}

	public String getSub2(){
		return sub2;
	}

	public void setSub3(String sub3){
		this.sub3 = sub3;
	}

	public String getSub3(){
		return sub3;
	}

	public void setShift(String shift){
		this.shift = shift;
	}

	public String getShift(){
		return shift;
	}

	public void setSub1(String sub1){
		this.sub1 = sub1;
	}

	public String getSub1(){
		return sub1;
	}

	public void setRid(String rid){
		this.rid = rid;
	}

	public String getRid(){
		return rid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSub6obt(String sub6obt){
		this.sub6obt = sub6obt;
	}

	public String getSub6obt(){
		return sub6obt;
	}

	public void setSub4obt(String sub4obt){
		this.sub4obt = sub4obt;
	}

	public String getSub4obt(){
		return sub4obt;
	}

	public void setJsonMemberClass(String jsonMemberClass){
		this.jsonMemberClass = jsonMemberClass;
	}

	public String getJsonMemberClass(){
		return jsonMemberClass;
	}

	public void setSub2obt(String sub2obt){
		this.sub2obt = sub2obt;
	}

	public String getSub2obt(){
		return sub2obt;
	}

	public void setSub5obt(String sub5obt){
		this.sub5obt = sub5obt;
	}

	public String getSub5obt(){
		return sub5obt;
	}

	public void setSub3obt(String sub3obt){
		this.sub3obt = sub3obt;
	}

	public String getSub3obt(){
		return sub3obt;
	}

	@Override
 	public String toString(){
		return 
			"StudentItem{" + 
			"sub1obt = '" + sub1obt + '\'' + 
			",sub6 = '" + sub6 + '\'' + 
			",sub4 = '" + sub4 + '\'' + 
			",sub5 = '" + sub5 + '\'' + 
			",sub2 = '" + sub2 + '\'' + 
			",sub3 = '" + sub3 + '\'' + 
			",shift = '" + shift + '\'' + 
			",sub1 = '" + sub1 + '\'' + 
			",rid = '" + rid + '\'' + 
			",name = '" + name + '\'' + 
			",sub6obt = '" + sub6obt + '\'' + 
			",sub4obt = '" + sub4obt + '\'' + 
			",class = '" + jsonMemberClass + '\'' + 
			",sub2obt = '" + sub2obt + '\'' + 
			",sub5obt = '" + sub5obt + '\'' + 
			",sub3obt = '" + sub3obt + '\'' + 
			"}";
		}
}