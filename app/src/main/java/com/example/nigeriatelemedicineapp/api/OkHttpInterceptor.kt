package com.example.nigeriatelemedicineapp.api

import android.util.Base64
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpInterceptor {

    private val httpClient = OkHttpClient.Builder()
   init {

   }
    fun getClient(username: String?, password: String?) : OkHttpClient
    {
        if (username != null && password != null) {
            val credentials = "$username:$password"
            val basic = "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
            httpClient.addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .header("Authorization", basic)
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())


                val request = requestBuilder.build()
                chain.proceed(request)
            }
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(loggingInterceptor)
        }
        return httpClient.build()
    }
}