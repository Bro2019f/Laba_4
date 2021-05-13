package com.example.myapplication
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

 class ParkingActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?){
         super.onCreate(savedInstanceState)
         setContentView(R.layout.parking_aktivity)
      initViev()
         }
     private fun initViev(){
         pleaseTv = findViewById(R.id.ID)
         startTimeTv=findViewById(R.id.startT)
         endTimeTv=findViewById(R.id.endT)
         priseTv=findViewById(R.id.prise)
         marcCarTv=findViewById(R.id.marcCar)
     }

     override fun onResume() {
         super.onResume()
         loadData()
     }


     lateinit var pleaseTv: TextView
     lateinit var startTimeTv: TextView
     lateinit var endTimeTv: TextView
     lateinit var priseTv: TextView
     lateinit var marcCarTv: TextView



     private fun loadData() {
         Log.d("API", "loadData")
         val service = TestApiService()
         service.getLocalWeather(object : TestApiService.WeatherCallback {
             override fun onSuccess(parking: Parking) {
                 displayParking(parking)
             }
             override fun onFailure() {
                 displayError()
             }
         })
     }
     private fun displayParking(parking: Parking) {
         Log.d("API", "${parking.please}")

         Log.d("API", "${parking.startTime}")
         Log.d("API", "${parking.endTime}")
         Log.d("API", "${parking.prise}")
         Log.d("API", "${parking.marcCar}")
         pleaseTv.setText("Parking at: ${parking.please}")

         startTimeTv.setText("Parking: ${parking.startTime}")
         endTimeTv.setText("Parking: ${parking.endTime}")
         priseTv.setText("Parking: ${parking.prise}")
         marcCarTv.setText("Parking: ${parking.marcCar}")
     }
     private fun displayError() {
         Log.d("API", "error loading data")
         Toast.makeText(ParkingActivity@ this,"You WIN",
             Toast.LENGTH_LONG).show()
     }

     }
