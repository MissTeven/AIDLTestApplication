package com.example.edz.aidltestapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name;
    private String sex;
    private int age;

    protected Student(Parcel in) {
        name = in.readString();
        sex = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeInt(age);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }
    @Override
    public String toString() {
        return String.format("name:%s sex:%s age:%s", name, sex, age);
    }
}
