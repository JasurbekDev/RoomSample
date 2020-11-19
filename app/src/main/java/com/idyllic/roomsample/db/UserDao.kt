package com.idyllic.roomsample.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE age > :age")
    fun getUsersOver(age: Int): LiveData<List<User>>

    @Query("DELETE FROM user_table WHERE id = :id")
    fun deleteUser(id: Int)
}