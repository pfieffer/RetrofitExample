# JSON parsing using Retrofit library
This is a simple android app project which uses Retrofit library to parse JSON array and object from a URL to display on the app.

Gradle dependencies used are `//Retrofit`
    `compile 'com.squareup.retrofit:retrofit:2.0.0-beta2'`
    `compile 'com.google.code.gson:gson:1.7.2'`
    `//In retrofit2.0 gson converter is not included, so we need to plug it here`
    `compile 'com.squareup.retrofit:converter-gson:2.0.0-beta2'`
    `compile 'com.squareup.okhttp:okhttp:2.4.0'`

Internet permission is added AndroidManifest.xml
```XML
	<uses-permission android:name="android.permission.INTERNET" />
```

A POJO class is used to get and set the variables which is `Student.java`
```JAVA
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
```

There are two interfaces for JSON Array and JSON Object: `RetrofitArrayAPI.java` and `RetrofitObjectAPI.java`
```JAVA
public interface RetrofitArrayAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Student>> getStudentDetails();

}
```

```JAVA
public interface RetrofitObjectAPI {
    /*
    * Retrofit get annotation with our URL
    * And our method that will return us details of student.
   */
    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();
```

The app is a follow along of the tutorial posted on [AndroidTutorialPoint](https://www.androidtutorialpoint.com/networking/retrofit-android-tutorial/)

