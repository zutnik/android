package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import java.lang.Thread.sleep
import java.util.stream.DoubleStream.concat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rgColor = findViewById<RadioGroup>(R.id.radioGroup)
        val rgCoast = findViewById<RadioGroup>(R.id.radioGroup2)
        val btnEntr = findViewById<Button>(R.id.button)
        val btnClear = findViewById<Button>(R.id.button2)
        btnEntr.setOnClickListener {
            var rb_color_id = rgColor.checkedRadioButtonId
            var rb_coast_id = rgCoast.checkedRadioButtonId
            if (rb_coast_id == -1 || rb_color_id == -1) {
                Toast.makeText(this, "Будьласка виберете цену и цвет", LENGTH_LONG).show()
            } else {

                val rb_color = findViewById<RadioButton>(rb_color_id)
                val rb_coast = findViewById<RadioButton>(rb_coast_id)


                val toast = Toast.makeText(applicationContext, rb_coast.text, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER or Gravity.RIGHT, 25, 75)
                toast.show()
                val toast1 = Toast.makeText(baseContext, rb_color.text, LENGTH_LONG)
                toast1.setGravity(Gravity.CENTER or Gravity.LEFT, 25, 75)
                toast1.show()

            }
        }
        btnClear.setOnClickListener {
            rgCoast.clearCheck()
            rgColor.clearCheck()
        }
        val pre_checket_color = rgColor.getChildAt(1) as RadioButton
        pre_checket_color.setChecked(true)
        val pre_checket_coast = rgCoast.getChildAt(1) as RadioButton
        pre_checket_coast.setChecked(true)
    }
}
