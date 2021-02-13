package com.pandey.evilinsult.ui.main.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pandey.evilinsult.data.api.ApiHelper
import com.pandey.evilinsult.data.repository.MainRepository
import com.pandey.evilinsult.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}