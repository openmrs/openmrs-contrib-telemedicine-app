package org.fortitudo.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Link {

    @SerializedName("rel")
    @Expose
    private var rel: String? = null


    @SerializedName("uri")
    @Expose
    private var uri: String? = null

}






