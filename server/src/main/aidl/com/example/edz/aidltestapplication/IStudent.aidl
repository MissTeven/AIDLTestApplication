// IStudent.aidl
package com.example.edz.aidltestapplication;

// Declare any non-default types here with import statements
import com.example.edz.aidltestapplication.Student;

/*
注意事项
1.包名问题(务必保证直接拷贝的AIDL文件夹)
2.AIDL不支持同名不同参函数
3.使用自定义类型时需要在AIDL中声明
4.传递对象前加in
*/
interface IStudent {
    Student getData();
    void setData(in Student data);
    /*
    方法名不能相重
    */
    void setContent(String name,String sex,int age);
}
