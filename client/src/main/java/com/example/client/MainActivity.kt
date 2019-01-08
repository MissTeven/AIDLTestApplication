package com.example.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.edz.aidltestapplication.IStudent
import com.example.edz.aidltestapplication.Student

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    private var mStudentBinder: IStudent? = null
    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.d(TAG, "onServiceConnected")
            mStudentBinder = IStudent.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.d(TAG, "onServiceDisconnected")
            mStudentBinder = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bindService(view: View?) {
        var intent = Intent()
        intent.action = "com.example.edz.aidltestapplication.student"
        intent.component = ComponentName(
            "com.example.edz.aidltestapplication",
            "com.example.edz.aidltestapplication.StudentService"
        )
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    fun setData(view: View?) {
        if (mStudentBinder != null) {
            val student = Student()
            student.name = "Lucy"
            student.sex = "W"
            student.age = 21
            mStudentBinder!!.data = student
        }
    }

    fun getContent(view: View?) {
        if (mStudentBinder != null) {
            mStudentBinder!!.setContent("Jack", "男", 18)
        }
    }

    fun getData(view: View?) {
        if (mStudentBinder != null) {
            val student = mStudentBinder!!.data
            Log.d(TAG, student.toString())
        }
    }

    fun unbindService(view: View?) {
        if (mStudentBinder != null) {
            unbindService(mServiceConnection)
            mStudentBinder = null
        }
    }
}
