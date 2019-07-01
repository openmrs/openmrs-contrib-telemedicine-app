package com.example.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Attribute {

    @SerializedName("attributeType")
    @Expose
    var attributeType: AttributeType? = null
    @SerializedName("value")
    @Expose
    var value: String? = null

}