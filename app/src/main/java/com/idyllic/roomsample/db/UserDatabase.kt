package com.idyllic.roomsample.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [User::class], version = 3)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {

        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `user_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `age` INTEGER NOT NULL)")
            }
        }

        private var instance: UserDatabase? = null
        fun getInstance(application: Application): UserDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(application, UserDatabase::class.java, "user database")
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_2_3)
                    .build()
            }
            return instance!!
        }
    }
}