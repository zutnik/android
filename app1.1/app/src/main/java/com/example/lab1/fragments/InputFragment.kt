package com.example.lab1.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.lab1.R
import java.lang.ClassCastException

class InputFragment : Fragment() {

    private lateinit var onDataSentListener: OnDataSent

    interface OnDataSent {
        fun sendData(rgColor: RadioButton, rgCost: RadioButton)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onDataSentListener = context as OnDataSent
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement OnDataSent"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val rgColor: RadioGroup = view?.findViewById(R.id.radioGroup) as RadioGroup
        val rgCost: RadioGroup = view?.findViewById(R.id.radioGroup2) as RadioGroup
        val btnEntr: Button = view?.findViewById(R.id.button) as Button
        val btnClear: Button = view?.findViewById(R.id.button2) as Button

        btnEntr.setOnClickListener {
            val rb_color_id = rgColor.checkedRadioButtonId
            val rb_coast_id = rgCost.checkedRadioButtonId
            if (rb_coast_id == -1 || rb_color_id == -1) {
                Toast.makeText(getActivity(),"Выберите цвет и диапазон цены, пожалуйста",Toast.LENGTH_SHORT).show();
            } else {

                val rb_color: RadioButton = view?.findViewById(rb_color_id) as RadioButton
                val rb_coast: RadioButton = view?.findViewById(rb_coast_id) as RadioButton

                passData(rb_color, rb_coast)
            }
        }

        btnClear.setOnClickListener {
            rgCost.clearCheck()
            rgColor.clearCheck()
        }

        val pre_checket_color = rgColor.getChildAt(1) as RadioButton
        pre_checket_color.setChecked(true)
        val pre_checket_coast = rgCost.getChildAt(1) as RadioButton
        pre_checket_coast.setChecked(true)
    }

    private fun passData(rgColor: RadioButton, rgCost: RadioButton) {
        onDataSentListener.sendData(rgColor, rgCost)
    }

}