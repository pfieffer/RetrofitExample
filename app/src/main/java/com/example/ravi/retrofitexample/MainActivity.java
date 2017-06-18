package com.example.ravi.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView tv_studentId1, tv_studentName1, tv_studentMarks1, tv_studentId2, tv_studentName2, tv_studentMarks2;
    private Button btn1, btn2;
    private String url="https://androidtutorialpoint.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_studentId1 = (TextView) findViewById(R.id.tv_id1);
        tv_studentName1 = (TextView) findViewById(R.id.tv_name1);
        tv_studentMarks1 = (TextView) findViewById(R.id.tv_marks1);

        tv_studentId2 = (TextView) findViewById(R.id.tv_id2);
        tv_studentName2 = (TextView) findViewById(R.id.tv_name2);
        tv_studentMarks2 = (TextView) findViewById(R.id.tv_marks2);

        btn1 = (Button ) findViewById(R.id.btn_object);
        btn2 = (Button ) findViewById(R.id.btn_array);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","Okay so onclicklistener is working");
                getRetrofitObject();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRetrofitArray();
            }
        });



    }

    void getRetrofitObject() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<Student> call = service.getStudentDetails();

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Response<Student> response, Retrofit retrofit) {

                try {

                    tv_studentId1.setText("StudentId  :  " + response.body().getStudentId());
                    tv_studentName1.setText("StudentName  :  " + response.body().getStudentName());
                    tv_studentMarks1.setText("StudentMarks  : " + response.body().getStudentMarks());

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    void getRetrofitArray() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Student>> call = service.getStudentDetails();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Response<List<Student>> response, Retrofit retrofit) {

                try {

                    List<Student> StudentData = response.body();

                    for (int i = 0; i < StudentData.size(); i++) {

                        if (i == 0) {
                            tv_studentId1.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            tv_studentName1.setText("StudentName  :  " + StudentData.get(i).getStudentName());
                            tv_studentMarks1.setText("StudentMarks  : " + StudentData.get(i).getStudentMarks());
                        } else if (i == 1) {
                            tv_studentId2.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            tv_studentName2.setText("StudentName  :  " + StudentData.get(i).getStudentName());
                            tv_studentMarks2.setText("StudentMarks  : " + StudentData.get(i).getStudentMarks());
                        }
                    }


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }


}
