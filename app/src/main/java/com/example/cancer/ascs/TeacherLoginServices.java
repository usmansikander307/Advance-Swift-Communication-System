package com.example.cancer.ascs;

import com.example.cancer.ascs.ModelClasses.AdminArray;
import com.example.cancer.ascs.ModelClasses.DataOperator.DataOperatorbyid;
import com.example.cancer.ascs.ModelClasses.InsertNotification;
import com.example.cancer.ascs.ModelClasses.Insertresult;
import com.example.cancer.ascs.ModelClasses.NotificationArrayItem;
import com.example.cancer.ascs.ModelClasses.StatusResponse;
import com.example.cancer.ascs.ModelClasses.Student.StuddentById;
import com.example.cancer.ascs.ModelClasses.StudentArray;
import com.example.cancer.ascs.ModelClasses.Teacher.TeacherByid;
import com.example.cancer.ascs.ModelClasses.TeacherNameResponse;
import com.example.cancer.ascs.ModelClasses.UpdateStatusResponse;
import com.example.cancer.ascs.ModelClasses.UpdatesuccesfullyResponse;
import com.example.cancer.ascs.ModelClasses.ViewNotification;
import com.example.cancer.ascs.ModelClasses.ViewResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TeacherLoginServices {
    @FormUrlEncoded
    @POST(EndPoint.TEACHER_LOGIN)
    Call<UpdateStatusResponse> teacherSignin (@Field("email") String email,
                                              @Field("password") String password);
    @FormUrlEncoded
    @POST(EndPoint.ADMIN_LOGIN)
    Call<Admin> adminSignin (@Field("email") String email,
                                              @Field("pass") String password);
    @FormUrlEncoded
    @POST(EndPoint.DO_LOGIN)
    Call<DataOperator> doSignin (@Field("email") String email,
                                              @Field("pass") String password);


    @GET(EndPoint.TEACHERS_NAME)
    Call<TeacherNameResponse> teacherName ();

    @FormUrlEncoded
    @POST(EndPoint.SHOW_STATUS)
    Call<StatusResponse> statusView (@Field("f_name") String f_name);

    @FormUrlEncoded
    @POST(EndPoint.UPDATE_STATUS)
    Call<UpdatesuccesfullyResponse> teacherupdate (@Field("name") String name,
                                                   @Field("status") String status);

    @FormUrlEncoded
    @POST(EndPoint.Insert_Notification)
    Call<InsertNotification> notification (@Field("name") String name,
                                           @Field("date") String date,
                                           @Field("body") String body);


    @POST(EndPoint.SHOW_NOTIFICATION)
    Call<ViewNotification<NotificationArrayItem>> shownotification ();


    @FormUrlEncoded
    @POST(EndPoint.InsertResult)
    Call<Insertresult> result (@Field("name") String name,
                               @Field("arid") String arid,
                                     @Field("class") String cl,
                                     @Field("shift") String shift,
                               @Field("c1") String S1,
                               @Field("c1num") Float num1,
                               @Field("c2") String S2,
                               @Field("c2num") Float num2,
                               @Field("c3") String S3,
                               @Field("c3num") Float num3,
                               @Field("c4") String S4,
                               @Field("c4num") Float num4,
                               @Field("c5") String S5,
                               @Field("c5num") Float num5,
                               @Field("c6") String S6,
                               @Field("c6num") Float num6);

    @POST(EndPoint.SelectStudent)
    Call<StudentArray> selectStudents();


    @POST(EndPoint.SelectAdmin)
    Call<AdminArray> selectAdmins();


    @FormUrlEncoded
    @POST(EndPoint.TAKE_ATTENDANCE)
    Call<UpdatesuccesfullyResponse> takeAttandance (@Field("dept") int dept, @Field("sub") int sub, @Field("student") int student, @Field("date") String date, @Field("status") String status );

    @FormUrlEncoded
    @POST(EndPoint.viewresult)
    Call<ViewResult> showResult(@Field("arid") String AridNo,@Field("class") String StudentClass);

    @FormUrlEncoded
    @POST(EndPoint.URL_SINGLE)
    Call<StuddentById> showStudentData(@Field("pid") String StudentID);

    @FormUrlEncoded
    @POST(EndPoint.URL_DELETE)
    Call<StatusResponse> deleteStudentData(@Field("pid") String StudentID);

    @FormUrlEncoded
    @POST(EndPoint.URL_UPDATE)
    Call<StatusResponse> updateStudentData(@Field("sid") String StudentID,@Field("sname") String Studentname,@Field("semail") String Studentemail,@Field("scont") String Studentcont,@Field("spass") String Studentpass,
                                          @Field("sarid") String Studentarid );
    @FormUrlEncoded
    @POST(EndPoint.URL_SINGLETEACHER)
    Call<TeacherByid> showTeacherData(@Field("pid") String TeacherID);

    @FormUrlEncoded
    @POST(EndPoint.URL_DELETETEACHER)
    Call<StatusResponse> deleteTeacherData(@Field("pid") String TeacherID);

    @FormUrlEncoded
    @POST(EndPoint.URL_UPDATETEACHER)
    Call<StatusResponse> updateTeacherData(@Field("sid") String TeacherID,@Field("sname") String Teachername,@Field("semail") String Teacheremail,@Field("scont") String Teachercont,@Field("spass") String Teacherpass,
                                           @Field("squal") String Teacherqual
    );

    @FormUrlEncoded
    @POST(EndPoint.URL_SINGLEDO)
    Call<DataOperatorbyid> showdataoperatorData(@Field("pid") String TeacherID);

    @FormUrlEncoded
    @POST(EndPoint.URL_DELETEDO)
    Call<StatusResponse> deletedataoperatorData(@Field("pid") String TeacherID);

    @FormUrlEncoded
    @POST(EndPoint.URL_UPDATEDO)
    Call<StatusResponse> updatedataoperatorData(@Field("sid") String DoID,@Field("sname")String Doname,@Field("semail")String Doemail, @Field("spass") String Dopass ,@Field("scont") String Docont);



}
