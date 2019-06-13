package com.example.nigeriatelemedicineapp.api.services

import com.example.nigeriatelemedicineapp.api.models.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegisterPatientService{

    @Headers(
        "accept: application/json",
        "content-type: application/json"
        //"authorization: Basic YWRtaW46QWRtaW4xMjM="
    )
    @POST("patient")
    fun registerPatient(@Body patient: Patient): Call<String?>
}