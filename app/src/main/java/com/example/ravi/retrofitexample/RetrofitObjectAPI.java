package com.example.ravi.retrofitexample;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by ravi on 6/18/2017.
 */

public interface RetrofitObjectAPI {
    /*
    * Retrofit get annotation with our URL
    * And our method that will return us details of student.
   */
    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();
}
