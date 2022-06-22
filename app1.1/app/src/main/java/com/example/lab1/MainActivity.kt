package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import com.example.lab1.fragments.InputFragment
import com.example.lab1.fragments.OutputFragment

class MainActivity : AppCompatActivity(), InputFragment.OnDataSent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, inputFragment)
            .commit()


    }

    override fun sendData(rgColor: RadioButton, rgCost: RadioButton) {
        val outputFragment = OutputFragment()
        val bundle = Bundle()

        bundle.putString("rgColor", rgColor.text as String?)
        bundle.putString("rgCost", rgCost.text as String?)

        outputFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, outputFragment).addToBackStack(null).commit()
    }
}
