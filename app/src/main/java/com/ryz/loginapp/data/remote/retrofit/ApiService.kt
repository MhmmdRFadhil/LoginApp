package com.ryz.loginapp.data.remote.retrofit

import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/login")
    suspend fun login(
        @Body login: LoginEntity
    ): LoginResponse
}