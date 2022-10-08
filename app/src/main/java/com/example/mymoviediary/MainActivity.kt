package com.example.mymoviediary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mymoviediary.api.KobisAPI
import com.example.mymoviediary.model.ResultGetMovieChart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key = "${BuildConfig.KEY}"
        val naverClientId = "${BuildConfig.NAVERCLIENTID}"
        val naverClientSecret = "${BuildConfig.NAVERCLIENTSECRET}"
        val movieChartBaseURL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
        val naverMovieBaseURL = "https://openapi.naver.com/"

        var calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE , -1)
        val dataFormat = SimpleDateFormat("yyyyMMdd")
        val targetDt = dataFormat.format(calendar.getTime())

        val retrofit = Retrofit.Builder()
            .baseUrl(movieChartBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(KobisAPI::class.java)
        val callGetMovieChart = api.getMovieChart(key, targetDt)

        callGetMovieChart.enqueue(object : Callback<ResultGetMovieChart> {
            override fun onResponse(
                call: Call<ResultGetMovieChart>,
                response: Response<ResultGetMovieChart>
            ) {
                Log.d("결과", "성공 : ${response.body().toString()}")
            }

            override fun onFailure(call: Call<ResultGetMovieChart>, t: Throwable) {
                Log.d("결과:", "실패 : $t")
            }
        })
    }
}