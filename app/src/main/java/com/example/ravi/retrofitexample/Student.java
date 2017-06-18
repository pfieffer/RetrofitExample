package com.example.ravi.retrofitexample;

/**
 * Created by ravi on 6/18/2017.
 */

public class Student {
    //This is a POJO class. POJO stands for Plain Old Java Object
    private int StudentId;
    private String StudentName;
    private String StudentMarks;

    //Getters
    public int getStudentId() {
        return StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentMarks() {
        return StudentMarks;
    }


    //setters
    public void setStudentId(int studentId) {
        this.StudentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.StudentName = studentName;
    }

    public void setStudentMarks(String studentMarks) {
        this.StudentMarks = studentMarks;
    }
}
