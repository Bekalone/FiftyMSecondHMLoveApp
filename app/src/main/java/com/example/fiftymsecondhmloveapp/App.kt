package com.example.fiftymsecondhmloveapp

import android.app.Application
import com.example.fiftymsecondhmloveapp.network.LoveApi
import com.example.fiftymsecondhmloveapp.network.RetrofitService

class App:Application() {

    companion object {
        lateinit var loveApi: LoveApi
    }
    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        loveApi = retrofitService.getApi()
    }
}