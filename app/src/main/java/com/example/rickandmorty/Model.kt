package com.example.rickandmorty

import org.koin.dsl.module

val appModule = module {

    single {
        CommunicationManager()
    }

    single {
        Characters()
    }
}