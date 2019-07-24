package com.example.nigeriatelemedicineapp.registerpatient

import android.app.AlertDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nigeriatelemedicineapp.api.ApiManager
import com.example.nigeriatelemedicineapp.api.models.*
import com.example.nigeriatelemedicineapp.repository.Repository
import com.example.nigeriatelemedicineapp.utils.DateUtlis
import com.example.nigeriatelemedicineapp.utils.StringUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RegisterPatientViewModel(_repository: Repository = Repository(ApiManager())) : ViewModel() {

    var repository: Repository

    val status: MutableLiveData<Status> by lazy {
        MutableLiveData<Status>()
    }

    val dialog: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        repository = _repository
    }

    fun checkNullValues(firstname: String, lastname: String, dob: String, gender: String, phone: String) {
        if (!StringUtils.check(firstname)) {
            status.value = Status.EMPTY_FIRST_NAME
        } else if (!StringUtils.check(lastname)) {
            status.value = Status.EMPTY_LAST_NAME
        } else if (!StringUtils.check(gender)) {
            status.value = Status.EMPTY_GENDER
        } else if (!StringUtils.check(dob)) {
            status.value = Status.EMPTY_DOB
        } else if (!DateUtlis.checkDateFormat(dob)) {
            status.value = Status.INCORRECT_DATE_FORMAT
        } else if (!StringUtils.check(phone)) {
            status.value = Status.EMPTY_PHONE
        } else {
            status.value = Status.SUCCESS
            registerPatient(firstname, lastname, DateUtlis.getCorrectDateFormat(dob), gender, phone)
        }
    }

    fun registerPatient(firstname: String, lastname: String, dob: String, gender: String, phone: String) {
            getIdentifier(firstname, lastname, dob, gender, phone)
    }

    private fun getIdentifier(firstname: String, lastname: String, dob: String, gender: String, phone: String) {
        repository.getIdentifier()?.enqueue(object : Callback<IdentifierList> {
            override fun onResponse(call: Call<IdentifierList>, response: Response<IdentifierList>) {
                if (response.code() == 200) {
                    val Uuid = response.body()?.getUuid()
                    createPatient(Uuid, firstname, lastname, dob, gender, phone)
                }
            }

            override fun onFailure(call: Call<IdentifierList>, t: Throwable) {
                dialog.postValue(0)
            }
        })
    }

    private fun createPatient(
        Uuid: String?,
        firstname: String,
        lastname: String,
        dob: String,
        gender: String,
        phone: String
    )
    {
        val name = Name()
        name.givenName = firstname
        name.familyName = lastname

        val attribute = Attribute()
        attribute.attributeType = AttributeType()
        attribute.value = phone

        val person = Person()
        person.names = listOf(name)
        person.gender = gender
        person.birthdate = dob
        person.attributes = listOf(attribute)

        val identifier = Identifier()
        identifier.identifier = Uuid

        Timber.d(
            "Creating patient with \n" +
                    "${identifier.identifier} \n" +
                    "and name ${name.givenName} ${name.familyName} \n" +
                    "DOB : $dob \n" +
                    "gender : $gender    \n" +
                    "phone : $phone"
        )

        val patient = Patient()
        patient.identifiers = listOf(identifier)
        patient.person = person

        syncPatient(patient)

    }

    private fun syncPatient(patient: Patient) {
        repository.registerPatient(patient)?.enqueue(object : Callback<Patient> {
            override fun onFailure(call: Call<Patient>, t: Throwable) {

             dialog.postValue(0)
             Timber.d(" t.localised message-----${t.localizedMessage} ")
             Timber.d(" t.message-----${t.message} ")
            }

            override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                if (response.code() == 201) {
                    dialog.postValue(201)
                    Timber.d("Patient registration successful")
                } else if(response.code() >= 500) {
                    dialog.postValue(500)
                }
                else if(response.code()>=400) {
                    dialog.postValue(400)
                }
                else{
                    dialog.postValue(0)
                }
            }


        })
    }

}