package com.example.rickandmorty


import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunicationManager() : KoinComponent {
    private val request = CommunicationBuilder.build(ArticlesEndpoints::class.java)

    val characters by inject<Characters>()

    fun getCharacter(page : String) {
        val call = request.getCharacter(page)
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    characters.dataLiveData.postValue(response.body())

                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                println("failure ${t.message}")
                characters.errorMassageLiveData.postValue(t.message)
            }
        })

    }

}