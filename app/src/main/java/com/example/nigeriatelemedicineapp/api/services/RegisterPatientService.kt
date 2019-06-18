package com.example.nigeriatelemedicineapp.api.services

import com.example.nigeriatelemedicineapp.api.ApiEndpoints
import com.example.nigeriatelemedicineapp.api.models.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegisterPatientService{

    @POST(ApiEndpoints.PATIENT)
    fun registerPatient(@Body patient: Patient): Call<Patient>
}