package com.example.lab1

import android.content.Context
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.Exception


class StorageService() {

    public fun readStorage(context: Context?, fileName: String): String {
        val fileInputStream: FileInputStream? =  context?.applicationContext?.openFileInput(fileName)
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String?
        while (run {
                text = bufferedReader.readLine()
                text
            } != null) {
            stringBuilder.append(text)
        }
        return stringBuilder.toString()
    }

    public fun writeFileOnInternalStorage(context: Context, fileName: String, fileData: String) {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = context.applicationContext.openFileOutput(fileName, Context.MODE_APPEND)
            fileOutputStream.write(("$fileData, ").toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}