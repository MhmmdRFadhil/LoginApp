package com.ryz.loginapp.data.repository

import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.remote.response.LoginResponse
import com.ryz.loginapp.data.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(private val service: ApiService) : LoginRepository {
    override suspend fun login(loginEntity: LoginEntity): Flow<LoginResponse> = flow {
        val response = service.login(loginEntity)
        emit(response)
    }.flowOn(Dispatchers.IO)
}