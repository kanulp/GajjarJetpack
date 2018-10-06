package com.kanu_lp.gajjarjetpacknavigation

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kanu_lp.gajjarjetpacknavigation.DeepLinkFragmentArgs.fromBundle
import kotlinx.android.synthetic.main.fragment_deep_link.*

class DeepLinkFragment : Fragment() {


    private val name by lazy {
        fromBundle(arguments).name
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_deep_link, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_name.text=name
    }
}