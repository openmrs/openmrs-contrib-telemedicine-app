package com.example.nigeriatelemedicineapp.registerpatient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.repository.Repository

class RegisterPatientViewModel : ViewModel() {

     var repository: Repository

    init {
        repository= Repository(ApiManager())
    }



}