package com.kanu_lp.gajjarworkmanager

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkerOneTime(context : Context, params : WorkerParameters) : Worker(context, params) {

    val TAG = "MainWorkOneTime"

    override fun doWork(): Result {

        readSMS()

        Log.d(TAG,"worker done work")
        return Result.SUCCESS
    }
    fun readSMS(){
        Log.d(TAG,"sms reading....")
        //val sms = mutableListOf<String>()
        val uriSms = Uri.parse("content://sms/inbox")
        val reqCols = arrayOf("_id", "address", "body")
        val cursor = applicationContext.contentResolver.query(uriSms, reqCols,null, null,null)
        while (cursor.moveToNext()) {
            val address = cursor.getString(1)
            val body = cursor.getString(2)
            Log.d(TAG, "Mobile :$address")
            Log.d(TAG, "text :$body")
            //   sms.add("Address=&gt; " + address + "n SMS =&gt; " + body)
        }
        cursor.close()
    }

}