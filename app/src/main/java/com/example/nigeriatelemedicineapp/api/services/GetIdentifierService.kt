package com.example.nigeriatelemedicineapp.api.services

import com.example.nigeriatelemedicineapp.api.ApiEndpoints
import com.example.nigeriatelemedicineapp.api.models.IdentifierList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface GetIdentifierService {

    @GET(ApiEndpoints.FETCH)
    fun getIdentifier(): Call<IdentifierList>
}