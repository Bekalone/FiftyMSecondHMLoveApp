package com.example.fiftymsecondhmloveapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fiftymsecondhmloveapp.model.LoveModel
import com.example.fiftymsecondhmloveapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository:Repository) :ViewModel() {

    fun getLiveLoveModel(firstName: String,secondName: String): MutableLiveData<LoveModel>{
        return repository.getMutableLiveDataOfLoveModel(firstName,secondName)
    }
}