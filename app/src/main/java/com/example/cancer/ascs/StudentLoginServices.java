package com.example.cancer.ascs;

import com.example.cancer.ascs.ModelClasses.DataOperator.FeedbackResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.RoomResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.ScheduleResponse;
import com.example.cancer.ascs.ModelClasses.DataOperator.SubjectResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StudentLoginServices {
    @FormUrlEncoded
    @POST(EndPoint.STUDENT_LOGIN)
    Call<Student> studentSignin (@Field("email") String email,
                                 @Field("pass") String password);

    @POST(EndPoint.Room)
    Call<RoomResponse> selectRoom ();

    @POST(EndPoint.Subject)
    Call<SubjectResponse> selectSubject ();

    @FormUrlEncoded
    @POST(EndPoint.insertSchedule)
    Call<ScheduleResponse> UploadeSchedule (@Field("tname") String Tname, @Field("rname") String rname, @Field("time") String Time,
                                            @Field("shift") String shift, @Field("day") String day, @Field("sec") String sec,
                                            @Field("crs") String crs, @Field("deg") String deg, @Field("dep") String dep,
                                            @Field("sem") String sem, @Field("timer") String timer);

    @FormUrlEncoded
    @POST(EndPoint.Feedback)
    Call<ScheduleResponse> UploadeFeedback (@Field("q1") String q1, @Field("q2") String q2, @Field("q3") String q3,
                                            @Field("q4") String q4, @Field("q5") String q5, @Field("q6") String q6,
                                            @Field("date") String date, @Field("arid") String arid, @Field("clas") String clas);

    @POST(EndPoint.FeedbackView)
    Call<FeedbackResponse> FeedbackView ();
}
