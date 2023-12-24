package com.ryz.loginapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ryz.loginapp.data.local.entity.UserToken

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(userToken: UserToken)

    @Query("SELECT * FROM user_tokens LIMIT 1")
    fun getUserToken(): LiveData<UserToken>
}