package com.ryz.loginapp.data.repository

import com.ryz.loginapp.data.UserPagingSource
import com.ryz.loginapp.data.remote.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val service: ApiService) : UserRepository {
    override fun getUserPagingSource() = UserPagingSource(service)
}