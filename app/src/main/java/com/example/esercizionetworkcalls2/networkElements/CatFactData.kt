package com.example.esercizionetworkcalls2.networkElements

import com.google.gson.annotations.SerializedName

data class CatFactData(
    @SerializedName("fact")
    val fact: String?,
    @SerializedName("length")
    val length: Int?
)