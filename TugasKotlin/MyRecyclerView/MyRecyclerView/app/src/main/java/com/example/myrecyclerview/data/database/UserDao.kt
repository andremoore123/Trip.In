package com.example.myrecyclerview.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query("SELECT * FROM favorite_user ORDER BY id ASC")
    fun readAllData():List<User>

    @Insert
    fun insertAll(vararg user: User)
    @Delete
    fun delete(user: User)
}