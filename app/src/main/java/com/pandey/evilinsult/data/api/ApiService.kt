package com.pandey.evilinsult.data.api

import com.pandey.evilinsult.data.model.InsultModel
import retrofit2.http.GET

interface ApiService {


    @GET("/generate_insult.php?lang=en&type=json")
    suspend fun getInsult():InsultModel
}