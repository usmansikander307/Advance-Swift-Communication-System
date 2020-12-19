package com.example.cancer.ascs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimetableArray {

    @SerializedName("teacher_name")
    private String teacherName;

    @SerializedName("t_date")
    private String tDate;

    @SerializedName("t_time")
    private String tTime;

    @SerializedName("t_course")
    private String tCoure;

    @SerializedName("r_name")
    private String rName;

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

    public void settCoure(String tCoure){
        this.tCoure = tCoure;
    }

    public String gettCoure(){
        return tCoure;
    }
    
    public void setTTime(String tTime){
        this.tTime = tTime;
    }

    public String getTTime(){
        return tTime;
    }

    public void setRName(String rName){
        this.rName = rName;
    }

    public String getRName(){
        return rName;
    }

    @Override
    public String toString(){
        return
                "TimetableArrayItem{" +
                        "teacher_name = '" + teacherName + '\'' +
                        ",t_date = '" + tDate + '\'' +
                        ",t_time = '" + tTime + '\'' +
                        ",r_name = '" + rName + '\'' +
                        "}";
    }
}