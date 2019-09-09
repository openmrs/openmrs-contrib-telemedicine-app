package org.fortitudo.nigeriatelemedicineapp.repository

import org.fortitudo.nigeriatelemedicineapp.api.ApiManager
import org.fortitudo.nigeriatelemedicineapp.api.models.IdentifierList
import org.fortitudo.nigeriatelemedicineapp.api.models.Patient
import retrofit2.Call

public class Repository(apiManager: ApiManager){

 private var apiManagerInstance: ApiManager
    init {
        apiManagerInstance= apiManager
    }

    fun getIdentifier() : Call<IdentifierList>?
    {
        return apiManagerInstance.getsIdentifierApi()?.getIdentifier()
    }

    fun registerPatient(patient: Patient) : Call<Patient>?
    {
        return apiManagerInstance.getRegisterPatientApi()?.registerPatient(patient)
    }


}