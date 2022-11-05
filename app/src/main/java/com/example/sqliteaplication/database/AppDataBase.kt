package com.example.sqliteaplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sqliteaplication.database.daos.UserDao
import com.example.sqliteaplication.database.models.Users

@Database(entities = [Users::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun Dao(): UserDao

    companion object{

        private var INSTANCE : AppDataBase? = null

        @Synchronized
        fun getInstance(context : Context): AppDataBase{

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "database.db"
                ).build()
            }
            return INSTANCE as AppDataBase
        }
    }

}