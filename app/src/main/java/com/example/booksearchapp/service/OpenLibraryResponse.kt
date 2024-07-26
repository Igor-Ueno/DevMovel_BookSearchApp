package com.example.booksearchapp.service

import com.google.gson.annotations.SerializedName

data class OpenLibraryResponse(
    val main: Main
)

data class Main(
    @SerializedName("start")
    val start: Int,

    @SerializedName("num_found")
    val numFound: Int,

    @SerializedName("docs")
    val docs: List<Work>,

    @SerializedName("temp_max")
    val tempMax: Double,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("sea_level")
    val seaLevel: Int
)

data class Work(
    @SerializedName("cover_i")
    val coverI: Int,

    @SerializedName("has_fulltext")
    val hasFulltext: Boolean,

    @SerializedName("edition_count")
    val editionCount: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("author_name")
    val authorName: List<String>,

    @SerializedName("first_publish_year")
    val firstPublishYear: Int,

    @SerializedName("key")
    val key: String,

    @SerializedName("ia")
    val ia: List<String>,

    @SerializedName("author_key")
    val authorKey: List<String>,

    @SerializedName("public_scan_b")
    val publicScanB: Boolean,

    @SerializedName("doc")
    val doc: List<Edition>
)

data class Edition(

    @SerializedName("numFound")
    val numFound: Int,

    @SerializedName("start")
    val start: Int,

    @SerializedName("numFoundExact")
    val numFoundExact: Boolean,

    @SerializedName("docs")
    val docs: List<Doc>
)

data class Doc(
    @SerializedName("key")
    val key: String,

    @SerializedName("title")
    val title: String,
)