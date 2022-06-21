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

    @Query("DELETE FROM favorite_user WHERE :searchUser = user_id")
    fun deleteUser(searchUser: String?)

    @Query("SELECT COUNT(*) FROM favorite_user")
    fun countAllData():Int

    @Query("SELECT * FROM favorite_user LIMIT 1")
    fun selectFirstData(): User
}