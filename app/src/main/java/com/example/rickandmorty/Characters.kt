package com.example.rickandmorty

import androidx.lifecycle.MutableLiveData

class Characters {
    val dataLiveData = MutableLiveData<Data>()
    var errorMassageLiveData = MutableLiveData<String>()

}