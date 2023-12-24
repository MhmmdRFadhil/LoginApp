package com.ryz.loginapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ryz.loginapp.data.local.dao.UserDao
import com.ryz.loginapp.data.local.entity.UserToken

@Database(entities = [UserToken::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userTokenDao(): UserDao
}