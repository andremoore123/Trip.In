package com.example.myrecyclerview.data.database

import androidx.room.*

@Entity(tableName = "favorite_user")
data class User(
    val id: Int = 0,
    @PrimaryKey
    val user_id: String
)

