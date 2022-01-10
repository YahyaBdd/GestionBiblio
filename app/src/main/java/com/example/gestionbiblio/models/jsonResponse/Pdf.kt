package com.example.gestionbiblio.models.jsonResponse

import com.google.gson.annotations.SerializedName


data class Pdf (

  @SerializedName("isAvailable" ) var isAvailable : Boolean? = null

)