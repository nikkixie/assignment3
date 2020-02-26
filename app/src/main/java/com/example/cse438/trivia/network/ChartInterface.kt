package com.example.cse438.trivia.network


import com.example.cse438.trivia.data.TracksPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChartInterface {

    //https://api.deezer.com/


    @GET("chart/{chart_id}")
    suspend fun getTracks(@Path("chart_id") chart_id: String) : Response<TracksPayload>

}