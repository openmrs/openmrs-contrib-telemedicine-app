package org.fortitudo.nigeriatelemedicineapp.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Identifier {

    @SerializedName("identifier")
    @Expose
    var identifier: String? = null
    @SerializedName("identifierType")
    @Expose
    var identifierType: String? = "05a29f94-c0ed-11e2-94be-8c13b969e334"
    @SerializedName("location")
    @Expose
    var location: String? = "aff27d58-a15c-49a6-9beb-d30dcfc0c66e"
    @SerializedName("preferred")
    @Expose
    var preferred: Boolean? = true

}