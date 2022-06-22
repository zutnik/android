package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InternalStorageActivity : AppCompatActivity() {

    private val storageService = StorageService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)

        val storageData: String = storageService.readStorage(applicationContext, "myFile")
        val textView: TextView = findViewById(R.id.internalStorageData)

        if (storageData == "") {
            textView.text = "Внутреннее хранилище пусто"
        }

        textView.text = storageData
    }
}