package com.example.cse438.trivia.network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.trivia.data.TracksPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ChartRepository {
    val service = ApiClient.makeRetrofitService()


    fun getTracks(resBody: MutableLiveData<TracksPayload>, input : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getTracks("2")
            withContext(Dispatchers.Main) {
                try{
                    if(response.isSuccessful) {
                        resBody.value = response.body()
                    }
                } catch (e: HttpException) {
                    println("Http error")
                }
            }
        }
    }


//    fun getTrackByName(resBody: MutableLiveData<TrackPayload>, name: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.getTrackByName(name)
//
//            withContext(Dispatchers.Main) {
//                try{
//                    if(response.isSuccessful) {
//                        resBody.value = response.body()
//                    }
//                } catch (e: HttpException) {
//                    println("Http error")
//                }
//            }
//        }
//    }
}