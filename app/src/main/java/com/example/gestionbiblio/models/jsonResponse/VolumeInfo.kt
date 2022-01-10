package com.example.example

import com.example.gestionbiblio.models.jsonResponse.IndustryIdentifiers
import com.example.gestionbiblio.models.jsonResponse.PanelizationSummary
import com.google.gson.annotations.SerializedName


data class VolumeInfo (

  @SerializedName("title"               ) var title               : String?                        = null,
  @SerializedName("authors"             ) var authors             : ArrayList<String>              = arrayListOf(),
  @SerializedName("publishedDate"       ) var publishedDate       : String?                        = null,
  @SerializedName("description"         ) var description         : String?                        = null,
  @SerializedName("industryIdentifiers" ) var industryIdentifiers : ArrayList<IndustryIdentifiers> = arrayListOf(),
  @SerializedName("readingModes"        ) var readingModes        : ReadingModes?                  = ReadingModes(),
  @SerializedName("pageCount"           ) var pageCount           : Int?                           = null,
  @SerializedName("printType"           ) var printType           : String?                        = null,
  @SerializedName("maturityRating"      ) var maturityRating      : String?                        = null,
  @SerializedName("allowAnonLogging"    ) var allowAnonLogging    : Boolean?                       = null,
  @SerializedName("contentVersion"      ) var contentVersion      : String?                        = null,
  @SerializedName("panelizationSummary" ) var panelizationSummary : PanelizationSummary?           = PanelizationSummary(),
  @SerializedName("language"            ) var language            : String?                        = null,
  @SerializedName("previewLink"         ) var previewLink         : String?                        = null,
  @SerializedName("infoLink"            ) var infoLink            : String?                        = null,
  @SerializedName("canonicalVolumeLink" ) var canonicalVolumeLink : String?                        = null

)