package com.example.nigeriatelemedicineapp.api

import com.example.nigeriatelemedicineapp.api.services.GetIdentifierService
import com.example.nigeriatelemedicineapp.api.services.RegisterPatientService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager(baseUrl: String = BaseUrl().getUrl(),_okHttpClient: OkHttpClient = OkHttpInterceptor().getClient()) {

    private var BASE_URL : String
    var retrofit: Retrofit? = null
    var patientApi: RegisterPatientService? = null
    var identifierApi: GetIdentifierService? = null
    var okHttpClient : OkHttpClient

    init {
        okHttpClient= _okHttpClient
        BASE_URL=baseUrl
        createService()
    }

    fun createService() {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        setUpServices()

    }

    private fun setUpServices() {
        patientApi = createApi(RegisterPatientService::class.java)
        identifierApi = createApi(GetIdentifierService::class.java)
    }

    fun <T> createApi(clazz: Class<T>): T? {
        return retrofit?.create(clazz)
    }

    fun getsIdentifierApi(): GetIdentifierService? {
        return identifierApi
    }

    fun getRegisterPatientApi(): RegisterPatientService? {
        return patientApi
    }
}