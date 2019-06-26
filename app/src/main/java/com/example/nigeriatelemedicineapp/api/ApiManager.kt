package com.example.nigeriatelemedicineapp.api

import com.example.nigeriatelemedicineapp.api.services.GetIdentifierService
import com.example.nigeriatelemedicineapp.api.services.RegisterPatientService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiManager {

    private val baseUrl = BaseUrl()
    private val BASE_URL = baseUrl.getUrl()
    private val username: String = "admin"
    private val password: String = "Admin123"
    private var retrofit: Retrofit? = null
    private var patientApi: RegisterPatientService? = null
    private var identifierApi: GetIdentifierService? = null


    init {
        createService()
    }

    fun createService() {
        val OkHttpClient = OkHttpInterceptor().getClient(username, password)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient)
            .build()

        setUpServices()

    }

    private fun setUpServices() {
        patientApi = createApi(RegisterPatientService::class.java)
        identifierApi = createApi(GetIdentifierService::class.java)
    }

    private fun <T> createApi(clazz: Class<T>): T? {
        return retrofit?.create(clazz)
    }

    fun getIdentifierApi(): GetIdentifierService? {
        return identifierApi
    }

    fun getRegisterPatientApi(): RegisterPatientService? {
        return patientApi
    }
}