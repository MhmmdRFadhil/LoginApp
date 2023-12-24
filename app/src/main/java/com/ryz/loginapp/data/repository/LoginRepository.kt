package com.ryz.loginapp.data.repository

import androidx.lifecycle.LiveData
import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.local.entity.UserToken
import com.ryz.loginapp.data.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getLoginToken(): LiveData<UserToken>
    suspend fun insertToken(token: String)
    suspend fun login(loginEntity: LoginEntity): Flow<LoginResponse>
}