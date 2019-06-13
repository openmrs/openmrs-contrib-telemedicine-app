package com.example.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Patient {

    @SerializedName("uuid")
    @Expose
    var uuid: String? = null

    @SerializedName("display")
    @Expose
    protected var display: String? = null

    @SerializedName("links")
    @Expose
    protected var links: List<Link>? = null

    @SerializedName("identifiers")
    @Expose
    var identifiers: List<Identifier>? = null
    @SerializedName("person")
    @Expose
    var person: Person? = null

    @SerializedName("voided")
    @Expose
    private var voided: Boolean? = null

    @SerializedName("resourceVersion")
    @Expose
    private var resourceVersion: String? = null

}