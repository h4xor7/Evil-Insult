package com.pandey.evilinsult.data.repository

import com.pandey.evilinsult.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getInsult() = apiHelper.getInsult()

}