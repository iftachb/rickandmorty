package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    // Inject HelloService
    val communicationManager by inject<CommunicationManager>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.llMainScreenContainer, MainScreenFragment()).commit()

        // call the communication
        communicationManager.getCharacter("1")
    }
}