package com.example.myapplication



import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Parking {
    @SerializedName("please")
    @Expose
    var please: String? = null


    @SerializedName("startTime")
    @Expose
    var startTime: String? = null

    @SerializedName("endTime")
    @Expose
    var endTime: String? = null

    @SerializedName("prise")
    @Expose
    var prise: String? = null

    @SerializedName("MarcCar")
    @Expose
    var marcCar: String? = null
}