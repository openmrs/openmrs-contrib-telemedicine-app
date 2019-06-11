package com.example.nigeriatelemedicineapp.api

class BaseUrl{
    val PROTOCOL_HTTPS = "https://"

    val HOST = "openmrs-staging.callnigeriandoc.com"
    val API_PATH = "/openmrs/ws/rest/v1/"

    fun getUrl(): String {
        return PROTOCOL_HTTPS + HOST + API_PATH
    }
}