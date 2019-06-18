package com.example.nigeriatelemedicineapp.api.services

import com.example.nigeriatelemedicineapp.api.models.IdentifierList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface GetIdentifierService {

    @GET
    fun getIdentifier(@Url url: String ="https://openmrs-staging.callnigeriandoc.com/openmrs/module/idgen/generateIdentifier.form?source=1&username=admin&password=Admin123"): Call<IdentifierList>
}