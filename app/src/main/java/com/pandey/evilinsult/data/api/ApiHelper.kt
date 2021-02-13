package com.pandey.evilinsult.data.api

class ApiHelper(private val apiService: ApiService) {

suspend fun  getInsult() = apiService.getInsult()
}