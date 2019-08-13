package com.example.nigeriatelemedicineapp.api

class BaseUrl {

    val PROTOCOL_HTTPS = "https://"
    val HOST = "openmrs-cng-staging.homefry.tk"
    val API_PATH = "/mobile-gateway/"

    fun getUrl(): String {
        return PROTOCOL_HTTPS + HOST + API_PATH
    }
}