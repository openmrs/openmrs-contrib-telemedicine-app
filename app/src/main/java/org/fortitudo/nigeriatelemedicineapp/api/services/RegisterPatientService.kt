package org.fortitudo.nigeriatelemedicineapp.api.services

import org.fortitudo.nigeriatelemedicineapp.api.ApiEndpoints
import org.fortitudo.nigeriatelemedicineapp.api.models.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterPatientService{

    @POST(ApiEndpoints.REGISTER)
    fun registerPatient(@Body patient: Patient): Call<Patient>
}