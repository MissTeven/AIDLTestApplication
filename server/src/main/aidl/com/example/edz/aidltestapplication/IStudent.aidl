// IStudent.aidl
package com.example.edz.aidltestapplication;

// Declare any non-default types here with import statements
import com.example.edz.aidltestapplication.Student;
interface IStudent {
    Student getData();
    void setData(in Student data);
    /*
    方法名不能相重
    */
    void setContent(String name,String sex,int age);
}
