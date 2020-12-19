package com.example.cancer.ascs;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StatusService {
    @FormUrlEncoded
    @POST(EndPoint.SHOW_STATUS)
    Call<TeacherStatus> showStatus(@Field("f_name") String f_name);
}
