package com.example.fiftymsecondhmloveapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fiftymsecondhmloveapp.model.LoveModel
import com.example.fiftymsecondhmloveapp.repository.Repository

class LoveViewModel :ViewModel() {

    private val repository = Repository()

    fun getLiveLoveModel(firstName: String,secondName: String): MutableLiveData<LoveModel>{
        return repository.getMutableLiveDataOfLoveModel(firstName,secondName)
    }
}