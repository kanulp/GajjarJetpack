package com.kanu_lp.gajjarjetpacknavigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.kanu_lp.gajjarjetpacknavigation.R


class PassDataFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_passdata, container, false)

        val tvId : TextView = view.findViewById(R.id.tv_passdata_id)
        val tvpass : TextView = view.findViewById(R.id.tv_passdata_password)

        val id = PassDataFragmentArgs.fromBundle(arguments).id
        val pass = PassDataFragmentArgs.fromBundle(arguments).pass

        tvId.text= id.toString()
        tvpass.text = pass
        view.findViewById<View>(R.id.btn_passdata_return).setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_passDataFragment_to_firstFragment)
            Navigation.findNavController(view).popBackStack()
        }

        return view
    }
}
