package com.example.edz.aidltestapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log

class StudentService : Service() {
    companion object {
        val TAG = "StudentService"
    }

    private inner class StudentBinder : IStudent.Stub() {

        private var mStudent: Student? = null

        @Throws(RemoteException::class)
        override fun getData(): Student? {
            return mStudent
        }

        @Throws(RemoteException::class)
        override fun setData(data: Student) {
            mStudent = data
            Log.d(TAG, data.toString())
        }

        @Throws(RemoteException::class)
        override fun setContent(name: String?, sex: String?, age: Int) {
            if (mStudent == null) {
                mStudent = Student()
            }
            mStudent!!.name = name
            mStudent!!.sex = sex
            mStudent!!.age = age
            Log.d(TAG, mStudent.toString())
        }
    }

    private var mStudentBinder = StudentBinder()


    override fun onBind(intent: Intent): IBinder? {
        return mStudentBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind: ")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

}
