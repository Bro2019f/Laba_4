package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TestApi {
    @GET("b/609c2cf51a02f86e1f0addd3/1")
    fun getLocalParking(@Header("secret-key") secretKey : String): Call<Parking>
}