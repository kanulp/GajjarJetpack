package com.kanu_lp.gajjarworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkTwo(context : Context, params : WorkerParameters) : Worker(context, params) {

    val TAG = "MainWork2"


    override fun doWork(): Result {

        Log.d(TAG,"done work 2")

        return Result.SUCCESS
    }


}