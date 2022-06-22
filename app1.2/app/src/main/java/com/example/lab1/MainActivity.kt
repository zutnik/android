package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import com.example.lab1.fragments.InputFragment
import com.example.lab1.fragments.OutputFragment

class MainActivity : AppCompatActivity(), InputFragment.OnDataSent, InputFragment.OnShowStorage {

    private val storageService = StorageService()

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

        storageService.writeFileOnInternalStorage(applicationContext, "myFile", "Цвет: " + rgColor.text + ", Диапазон: " + rgCost.text)

//        Toast.makeText(applicationContext, "Сохранено во внутреннее хранилище", Toast.LENGTH_SHORT).show()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, outputFragment).addToBackStack(null).commit()
    }

    override fun showStorage() {
        val intent = Intent(this, InternalStorageActivity::class.java)
        startActivity(intent)
    }
}
