package com.muhsantech.musicapp

import com.muhsantech.musicapp.models.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: 75074e315amshfd34e977c9547a8p152781jsnb9ace2390e33",
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(
        @Query("q") query: String
    ) : Call<MyData>
}