package com.example.rickandmorty


import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("info")
    val info: Info? = null

    @SerializedName("results")
    val results: List<Results>? = null

}

class Info {
    @SerializedName("metaData")
    val count: Int = 0

    @SerializedName("pages")
    val pages: Int = 0

    @SerializedName("next")
    val next: String? = null

    @SerializedName("prev")
    val prev: String? = null

}
class Results {
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("name")
    val name: String? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("species")
    val species: String? = null

    @SerializedName("type")
    val type: String? = null

    @SerializedName("gender")
    val gender: String? = null

    @SerializedName("origin")
    val origin: Origin? = null

    @SerializedName("location")
    val location: Origin? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("url")
    val url: String? = null

    @SerializedName("episode")
    val episode: List<String?>? = null

    @SerializedName("created")
    val created: String? = null
}

class Origin {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("url")
    val url: String? = null
}
