package com.example.sqliteaplication.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sqliteaplication.database.models.Users

@Dao
interface UserDao {

    @Insert
    fun insert(users: Users)
}