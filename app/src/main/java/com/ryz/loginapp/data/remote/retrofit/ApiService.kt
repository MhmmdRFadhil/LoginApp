package com.ryz.loginapp.data.remote.retrofit

import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.remote.response.LoginResponse
import com.ryz.loginapp.data.remote.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("api/login")
    suspend fun login(
        @Body login: LoginEntity
    ): LoginResponse

    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): UserResponse
}