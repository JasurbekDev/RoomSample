package com.idyllic.roomsample.db

import androidx.lifecycle.LiveData
import com.idyllic.roomsample.db.User

interface UserRepository {
    fun insert(user: User)
    fun getAllUsers(): LiveData<List<User>>
    fun getUsersOver(age: Int): LiveData<List<User>>
    fun deleteUser(id: Int)
}