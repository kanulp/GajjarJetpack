package com.kanu_lp.gajjarworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkThree(context : Context, params : WorkerParameters) : Worker(context, params) {

    val TAG = "MainWork3"


    override fun doWork(): Result {

        Log.d(TAG,"done work 3")

        return Result.SUCCESS
    }


}