package com.example.cancer.ascs.ModelClasses.Student;


import com.google.gson.annotations.SerializedName;

public class TimetableArrayItem{

	@SerializedName("t_id")
	private int tId;

	@SerializedName("teacher_name")
	private String teacherName;

	@SerializedName("t_date")
	private String tDate;

	@SerializedName("t_shift")
	private String tShift;

	@SerializedName("t_department")
	private String tDepartment;

	@SerializedName("t_time")
	private String tTime;

	@SerializedName("t_section")
	private String tSection;

	@SerializedName("t_degree")
	private String tDegree;

	@SerializedName("t_course")
	private String tCourse;

	@SerializedName("t_semester")
	private int tSemester;

	@SerializedName("r_name")
	private String rName;

	@SerializedName("t_day")
	private String tDay;

	public void setTId(int tId){
		this.tId = tId;
	}

	public int getTId(){
		return tId;
	}

	public void setTeacherName(String teacherName){
		this.teacherName = teacherName;
	}

	public String getTeacherName(){
		return teacherName;
	}

	public void setTDate(String tDate){
		this.tDate = tDate;
	}

	public String getTDate(){
		return tDate;
	}

	public void setTShift(String tShift){
		this.tShift = tShift;
	}

	public String getTShift(){
		return tShift;
	}

	public void setTDepartment(String tDepartment){
		this.tDepartment = tDepartment;
	}

	public String getTDepartment(){
		return tDepartment;
	}

	public void setTTime(String tTime){
		this.tTime = tTime;
	}

	public String getTTime(){
		return tTime;
	}

	public void setTSection(String tSection){
		this.tSection = tSection;
	}

	public String getTSection(){
		return tSection;
	}

	public void setTDegree(String tDegree){
		this.tDegree = tDegree;
	}

	public String getTDegree(){
		return tDegree;
	}

	public void setTCourse(String tCourse){
		this.tCourse = tCourse;
	}

	public String getTCourse(){
		return tCourse;
	}

	public void setTSemester(int tSemester){
		this.tSemester = tSemester;
	}

	public int getTSemester(){
		return tSemester;
	}

	public void setRName(String rName){
		this.rName = rName;
	}

	public String getRName(){
		return rName;
	}

	public void setTDay(String tDay){
		this.tDay = tDay;
	}

	public String getTDay(){
		return tDay;
	}

	@Override
 	public String toString(){
		return
			"TimetableArrayItem{" +
			"t_id = '" + tId + '\'' +
			",teacher_name = '" + teacherName + '\'' +
			",t_date = '" + tDate + '\'' +
			",t_shift = '" + tShift + '\'' +
			",t_department = '" + tDepartment + '\'' +
			",t_time = '" + tTime + '\'' +
			",t_section = '" + tSection + '\'' +
			",t_degree = '" + tDegree + '\'' +
			",t_course = '" + tCourse + '\'' +
			",t_semester = '" + tSemester + '\'' +
			",r_name = '" + rName + '\'' +
			",t_day = '" + tDay + '\'' +
			"}";
		}
}