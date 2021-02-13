package com.pandey.evilinsult.data.model

import com.google.gson.annotations.SerializedName

data class InsultModel(
    @SerializedName("number") val number : Int,
    @SerializedName("language") val language : String,
    @SerializedName("insult") val insult : String,
    @SerializedName("created") val created : String,
    @SerializedName("shown") val shown : Int,
    @SerializedName("createdby") val createdby : String,
    @SerializedName("active") val active : Int,
    @SerializedName("comment") val comment : String
    )
