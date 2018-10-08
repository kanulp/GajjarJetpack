package com.kanu_lp.gajjarworkmanager

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_READ_SMS = 11
    val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkSmsRequest()){
            val constraints :  Constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

            val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorkerOneTime::class.java)
                    .setConstraints(constraints)
                    .build()

            val periodicWorkRequest = PeriodicWorkRequest.Builder(MyWorkerPeriodic::class.java,10,TimeUnit.SECONDS)
                    .setConstraints(constraints)
                    .build()

           // WorkManager.getInstance().enqueue(periodicWorkRequest)

///////////////////-------------Chainable----------------------------------------
            val oneTimeWorkRequest1 = OneTimeWorkRequest.Builder(WorkOne::class.java).build()
            val oneTimeWorkRequest2 = OneTimeWorkRequest.Builder(WorkTwo::class.java).build()
            val oneTimeWorkRequest3 = OneTimeWorkRequest.Builder(WorkThree::class.java).build()

            WorkManager.getInstance()
                    .beginWith(oneTimeWorkRequest1,oneTimeWorkRequest2)
                    .then(oneTimeWorkRequest3)
                    .enqueue()
        }else
        {
            Toast.makeText(applicationContext,"Please Give Permission to read SMS",Toast.LENGTH_SHORT).show()
        }

    }

    private fun checkSmsRequest(): Boolean {

        var ispermission = false

        if (ContextCompat.checkSelfPermission(this@MainActivity,
                        Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG,"main if ")

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                            Manifest.permission.READ_SMS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.\
                Toast.makeText(applicationContext,"We need sms read permission",Toast.LENGTH_SHORT).show()
                Log.d(TAG,"if ")
            } else {
                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this@MainActivity,
                        arrayOf(Manifest.permission.READ_SMS),
                        MY_PERMISSIONS_REQUEST_READ_SMS)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
                Log.d(TAG,"else ")
            }
        } else {
            // Permission has already been granted
            ispermission = true
            Log.d(TAG,"gien perm ")
        }
        return ispermission
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_SMS -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }
}
