package com.example.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IdentifierList {

    @SerializedName("identifiers")
    @Expose
    var identifiers: List<String>? = null

    fun getUuid() : String?
    {
        return identifiers?.get(0)
    }

}