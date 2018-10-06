package com.kanu_lp.gajjarjetpacknavigation

import kotlin.LazyThreadSafetyMode.NONE
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import com.kanu_lp.gajjarjetpacknavigation.R

/**
 * A placeholder fragment containing a simple view.
 */
class FirstFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        view.findViewById<View>(R.id.button_first).setOnClickListener {
            val idTv: EditText = view.findViewById(R.id.editText_firstFrag_id)
            val passTv: EditText = view.findViewById(R.id.editText_firstFrag_pass)
            if(idTv.text.toString() == "") {
                idTv.error = "Please enter id"
                return@setOnClickListener
            }
            if(passTv.text.toString() == ""){
                passTv.error = "Please enter pass"
                return@setOnClickListener
            }
            navigatewithData(view,idTv.text.toString(),passTv.text.toString())
        }
        return view
    }


    private fun navigatewithData(view: View,id: String  ,pass: String) {

        val action = FirstFragmentDirections.actionFirstFragmentToPassDataFragment()
        action.setId(id.toInt())
        action.setPass(pass)
        Navigation.findNavController(view).navigate(action)

    }

}
