package com.example.nigeriatelemedicineapp.repository

import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.api.models.Identifier
import retrofit2.Call

class Repository(apiManager: ApiManager ){

 private var apiManagerInstance: ApiManager
    init {
        apiManagerInstance= apiManager
    }

    fun getIdentifier() : Call<Identifier>?
    {
        return apiManagerInstance.getIdentifierApi()?.getIdentifier()
    }


}