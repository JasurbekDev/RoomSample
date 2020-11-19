package com.idyllic.roomsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.idyllic.roomsample.db.User
import com.idyllic.roomsample.db.UserRepository
import com.idyllic.roomsample.db.UserRepositoryImpl

class UserViewModel(private val repository: UserRepository = UserRepositoryImpl()) : ViewModel() {
    fun insert(user: User) {
        repository.insert(user)
    }
    fun getAllUsers(): LiveData<List<User>> {
        return repository.getAllUsers()
    }
    fun getUsersOver(age: Int): LiveData<List<User>> {
        return repository.getUsersOver(age)
    }
    fun deleteUser(id: Int) {
        repository.deleteUser(id)
    }
}