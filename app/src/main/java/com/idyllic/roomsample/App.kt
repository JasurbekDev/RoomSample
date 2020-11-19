package com.idyllic.roomsample

import android.app.Application
import com.idyllic.roomsample.db.UserDatabase

lateinit var db: UserDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = UserDatabase.getInstance(this)
    }

}