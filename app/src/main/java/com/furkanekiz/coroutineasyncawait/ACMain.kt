package com.furkanekiz.coroutineasyncawait

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class ACMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)

        CoroutineScope(Main).launch {
            Log.i("MyTag", "Calculation started....")

            val stock1 = async(IO) {
                getStock1()
            }
            val stock2 = async(IO) {
                getStock2()
            }

            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_SHORT).show()
            //Log.i("MyTag", "Total is $total")
        }
    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.i("MyTag", " stock 1 returned ")
    return 55000
}

private suspend fun getStock2(): Int {
    delay(8000)
    Log.i("MyTag", " stock 2 returned ")
    return 35000
}