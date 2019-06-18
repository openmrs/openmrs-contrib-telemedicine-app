package com.example.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name {

    @SerializedName("givenName")
    @Expose
    var givenName: String? = null
    @SerializedName("familyName")
    @Expose
    var familyName: String? = null

}