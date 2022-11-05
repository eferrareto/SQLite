package com.example.sqliteaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sqliteaplication.database.App
import com.example.sqliteaplication.database.AppDataBase
import com.example.sqliteaplication.database.models.Users

class MainActivity : AppCompatActivity() {

    lateinit var dataBase: AppDataBase
    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = findViewById(R.id.txt_first_name)
        lastName = findViewById(R.id.txt_last_name)
        btnSave = findViewById(R.id.btn_save)

        btnSave.setOnClickListener{
            Thread{
                val app = application as App
                val dao = app.db.Dao()
                dao.insert(Users(firstName = firstName.text.toString(), lastName = lastName.text.toString()))
            }.start()
            val intent = Intent(this@MainActivity, NewUserActivity::class.java)
            startActivity(intent)
        }


    }
}