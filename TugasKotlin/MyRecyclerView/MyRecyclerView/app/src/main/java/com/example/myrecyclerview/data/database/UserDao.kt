package com.example.myrecyclerview.data.database

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query("SELECT * FROM favorite_user ORDER BY id ASC")
    fun readAllData():List<User>

    @Insert
    fun insertAll(vararg user: User)

    @Query("DELETE FROM favorite_user WHERE :user_id = user_id")
    fun deleteUser(user_id: String?)

    @Query("SELECT COUNT(*) FROM favorite_user")
    fun countAllData():Int

    @Query("SELECT * FROM favorite_user LIMIT 1")
    fun selectFirstData(): User
}