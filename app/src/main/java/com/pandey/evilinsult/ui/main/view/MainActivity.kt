package com.pandey.evilinsult.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pandey.evilinsult.R
import com.pandey.evilinsult.data.api.ApiHelper
import com.pandey.evilinsult.data.api.RetrofitBuilder
import com.pandey.evilinsult.data.model.InsultModel
import com.pandey.evilinsult.ui.main.viewmodel.MainViewModel
import com.pandey.evilinsult.ui.main.viewmodelfactory.MainViewModelFactory
import com.pandey.evilinsult.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViewModel()

        button.setOnClickListener{
            setupObservers()

        }

    }

    private fun setupObservers() {
        mainViewModel.getInsult().observe(this@MainActivity,{

            it?.let {
                resource ->
                when(resource.status){

                    Status.SUCCESS ->{

                        resource.data.let {
                            insultModel ->
                            if (insultModel!=null){
                                renderData(insultModel.insult)
                            }
                        }

                    }

                }
            }
        })
    }

    private fun renderData(insult: String) {

        insultText.text = insult
    }

    private fun setupViewModel() {

        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)

    }


}