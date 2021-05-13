package com.example.myapplication


import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.crypto.SecretKey

class TestApiService {
    companion object{
        const val SECRET_KEY = "\$2b\$10\$2bxru2FpN5NOHO/I9YBD9uHEqZC5oFjoTDaZTdmtZ3cnMM9o8TxoC"

    }
    var api: TestApi
    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(TestApi::class.java)
    }
    fun getLocalWeather(callback: WeatherCallback) {
        api.getLocalParking(SECRET_KEY).enqueue(object : Callback<Parking> {
            override fun onResponse(call: Call<Parking>, response:
            Response<Parking>
            ) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<Parking>, t: Throwable) {
                callback.onFailure()
            }
        })
    }interface WeatherCallback {
        fun onSuccess(weather: Parking)
        fun onFailure()
    }

}