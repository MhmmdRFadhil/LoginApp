package com.ryz.loginapp.data.repository

import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(loginEntity: LoginEntity): Flow<LoginResponse>
}