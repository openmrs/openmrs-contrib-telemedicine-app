package com.example.nigeriatelemedicineapp.registerpatient

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.api.models.*
import com.example.nigeriatelemedicineapp.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPatientViewModel : ViewModel() {

     var repository: Repository
    // Create a LiveData with a String
    val identifier: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val responseString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        repository= Repository(ApiManager())
    }

    fun registerPatient(firstname : String, lastname: String)
    {
        getIdentifier(firstname,lastname)
    }

    private fun getIdentifier(firstname : String, lastname: String) {
        repository.getIdentifier()?.enqueue(object : Callback<IdentifierList> {
            override fun onResponse(call: Call<IdentifierList>, response: Response<IdentifierList>) {
                if (response.code() == 200) {
                    val Uuid=response.body()?.getUuid()
                    identifier.postValue(Uuid)
                    createPatient(Uuid,firstname,lastname)
                }
            }
            override fun onFailure(call: Call<IdentifierList>, t: Throwable) {
                    identifier.postValue("Error fetching Identifier")
            }
        })
    }

    private fun createPatient(Uuid: String?, firstname: String, lastname: String) {
        val name = Name()
        name.givenName=firstname
        name.familyName=lastname

        val person= Person()
        person.names= listOf(name)

        val identifier= Identifier()
        identifier.identifier=Uuid

        Log.d("helaaa","Creating patient with ${identifier.identifier} and name ${name.givenName} ${name.familyName}")

        val patient= Patient()
        patient.identifiers= listOf(identifier)
        patient.person=person

        syncPatient(patient)

    }

    private fun syncPatient(patient: Patient) {
          repository.registerPatient(patient)?.enqueue(object : Callback<String?>{
              override fun onFailure(call: Call<String?>, t: Throwable) {
                 responseString.postValue("Patient Was not Created")
              }

              override fun onResponse(call: Call<String?>, response: Response<String?>) {
                   if(response.code()==201)
                   {
                       responseString.postValue("Patient Was Created with Code 201")
                   }
                  else{
                       response.body()
                       responseString.postValue("Patient Was not Created with code ${response.code()} code ")
                   }

              }


          })
    }

}