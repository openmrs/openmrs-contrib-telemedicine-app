package com.example.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Person {

    @SerializedName("gender")
    @Expose
    var gender: String? = "M"
    @SerializedName("age")
    @Expose
    var age: Int? = 49
    @SerializedName("birthdate")
    @Expose
    var birthdate: String? = null
    @SerializedName("birthdateEstimated")
    @Expose
    var birthdateEstimated: Boolean? = false
    @SerializedName("dead")
    @Expose
    var dead: Boolean? = false
    @SerializedName("deathDate")
    @Expose
    var deathDate: Any? = null
    @SerializedName("causeOfDeath")
    @Expose
    var causeOfDeath: Any? = null
    @SerializedName("names")
    @Expose
    var names: List<Name>? = null

}