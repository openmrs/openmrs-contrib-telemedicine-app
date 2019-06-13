package com.example.nigeriatelemedicineapp.repository

import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.api.models.IdentifierList
import com.example.nigeriatelemedicineapp.api.models.Patient
import retrofit2.Call

class Repository(apiManager: ApiManager ){

 private var apiManagerInstance: ApiManager
    init {
        apiManagerInstance= apiManager
    }

    fun getIdentifier() : Call<IdentifierList>?
    {
        return apiManagerInstance.getIdentifierApi()?.getIdentifier()
    }

    fun registerPatient(patient: Patient) : Call<String?>?
    {
        return apiManagerInstance.getRegisterPatientApi()?.registerPatient(patient)
    }


}