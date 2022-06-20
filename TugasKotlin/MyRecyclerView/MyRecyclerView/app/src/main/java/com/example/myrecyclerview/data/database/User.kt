package com.example.myrecyclerview.data.database

import androidx.room.*

@Entity(tableName = "favorite_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user_id: String
)

