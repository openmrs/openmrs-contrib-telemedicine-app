package com.example.nigeriatelemedicineapp.registerpatient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.api.models.*
import com.example.nigeriatelemedicineapp.repository.Repository
import com.example.nigeriatelemedicineapp.utils.StringUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RegisterPatientViewModel(_repository: Repository = Repository(ApiManager())) : ViewModel() {

     var repository: Repository

    val identifier: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val responseString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
         repository=_repository
    }

    fun registerPatient(firstname : String, lastname: String,dob : String,gender : String,phone : String)
    {
        if(StringUtils.notNull(firstname) && !StringUtils.isBlank(firstname))
           getIdentifier(firstname,lastname,dob,gender,phone)
    }

    private fun getIdentifier(firstname : String, lastname: String,dob : String,gender : String,phone : String) {
        repository.getIdentifier()?.enqueue(object : Callback<IdentifierList> {
            override fun onResponse(call: Call<IdentifierList>, response: Response<IdentifierList>) {
                if (response.code() == 200) {
                    val Uuid=response.body()?.getUuid()
                    identifier.postValue(Uuid)
                    createPatient(Uuid,firstname,lastname,dob,gender,phone)
                }
            }
            override fun onFailure(call: Call<IdentifierList>, t: Throwable) {
                    identifier.postValue("Error fetching Identifier")
            }
        })
    }

    private fun createPatient(Uuid: String?,firstname : String, lastname: String,dob : String,gender : String,phone : String) {
        val name = Name()
        name.givenName=firstname
        name.familyName=lastname

        val attribute= Attribute()
        attribute.attributeType= AttributeType()
        attribute.value=phone

        val person= Person()
        person.names= listOf(name)
        person.gender=gender
        person.birthdate=dob
        person.attributes= listOf(attribute)

        val identifier= Identifier()
        identifier.identifier=Uuid

        Timber.d("Creating patient with \n" +
                "${identifier.identifier} \n" +
                "and name ${name.givenName} ${name.familyName} \n" +
                "DOB : $dob \n" +
                "gender : $gender    \n" +
                "phone : $phone")

        val patient= Patient()
        patient.identifiers= listOf(identifier)
        patient.person=person

        syncPatient(patient)

    }

    private fun syncPatient(patient: Patient) {
          repository.registerPatient(patient)?.enqueue(object : Callback<Patient>{
              override fun onFailure(call: Call<Patient>, t: Throwable) {

                 responseString.postValue("Patient Was not Created")
                  Timber.d(" t.localised message-----${t.localizedMessage} ")
                  Timber.d(" t.message-----${t.message} ")
              }

              override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                   if(response.code()==201)
                   {
                       responseString.postValue("Patient Was Created with Code ${response.code()}")
                       Timber.d("Patient registration successful")
                   }
                  else{
                       responseString.postValue("Patient Was not Created with code ${response.code()} code ")
                   }

              }


          })
    }

}