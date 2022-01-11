package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insert(Contact(0,"Dev","48934",Date(),1))
        }


    }

    fun fn(view: android.view.View) {
        database.contactDao().getContact().observe(this,{ it ->
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        })
    }
}