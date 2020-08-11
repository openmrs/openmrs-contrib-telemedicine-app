package org.fortitudo.nigeriatelemedicineapp.api.services

import org.fortitudo.nigeriatelemedicineapp.api.ApiEndpoints
import org.fortitudo.nigeriatelemedicineapp.api.models.IdentifierList
import retrofit2.Call
import retrofit2.http.GET

interface GetIdentifierService {

    @GET(ApiEndpoints.FETCH)
    fun getIdentifier(): Call<IdentifierList>
}