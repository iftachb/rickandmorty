package com.example.rickandmorty

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticlesEndpoints {
    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/"
    }

    @GET("api/character/?page=1")
    fun getCharacter(): Call<Data>

    @GET("api/character/")
    fun getCharacter(@Query("page") page: String):  Call<Data>

}