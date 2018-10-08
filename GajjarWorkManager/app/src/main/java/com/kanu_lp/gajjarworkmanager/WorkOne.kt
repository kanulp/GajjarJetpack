package com.kanu_lp.gajjarworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkOne(context : Context, params : WorkerParameters) : Worker(context, params) {

    val TAG = "MainWork1"


    override fun doWork(): Result {

        Log.d(TAG,"done work 1")

        return Result.SUCCESS
    }


}