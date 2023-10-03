package com.muhsantech.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import com.muhsantech.musicapp.Network.ApiInterface
import com.muhsantech.musicapp.models.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // If the Api call is a success then this method is executed
                val dataList = response.body()?.data
                val textView = findViewById<TextView>(R.id.textView)
                textView.text = dataList.toString()
                Log.d("TAG: onResponse", "OnResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // If the API call is a failure then this method is  executed
                Log.d("TAG: onFailure", "onFailure: ${t.message.toString()}")
            }

        })


    }
}
