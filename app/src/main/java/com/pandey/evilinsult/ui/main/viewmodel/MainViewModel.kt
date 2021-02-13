package com.pandey.evilinsult.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pandey.evilinsult.data.repository.MainRepository
import com.pandey.evilinsult.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getInsult() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {

            emit(Resource.success(data = mainRepository.getInsult()))
        }
        catch (e:Exception){
            emit(Resource.error(data = null,message = e.message?:"Error Occurred!"))
        }
    }

}