package com.idyllic.roomsample.db

import androidx.lifecycle.LiveData
import com.idyllic.roomsample.db
import kotlin.concurrent.thread

class UserRepositoryImpl : UserRepository {
    private val userDao: UserDao = db.userDao

    override fun insert(user: User) {
        thread {
            userDao.insert(user)
        }
    }

    override fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()

    override fun getUsersOver(age: Int): LiveData<List<User>> = userDao.getUsersOver(age)

    override fun deleteUser(id: Int) = userDao.deleteUser(id)
}