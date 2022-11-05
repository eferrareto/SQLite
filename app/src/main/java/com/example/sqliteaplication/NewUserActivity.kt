package com.example.sqliteaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sqliteaplication.database.App
import com.example.sqliteaplication.database.models.Users

class NewUserActivity : AppCompatActivity() {
    lateinit var name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        name = findViewById(R.id.txtName)



        Thread{
            val app = application as App
            val dao = app.db.Dao()
            val response = dao.getNames()
            name.text = response.toString()
        }.start()
    }
}