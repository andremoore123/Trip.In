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
    @Query("DELETE FROM favorite_user")
    fun delete()

    @Query("SELECT COUNT(*) FROM favorite_user")
    fun countAllData():Int

    @Query("SELECT * FROM favorite_user LIMIT 1")
    fun selectFirstData(): User
}