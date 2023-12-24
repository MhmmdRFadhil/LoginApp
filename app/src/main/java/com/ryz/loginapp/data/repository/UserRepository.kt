package com.ryz.loginapp.data.repository

import com.ryz.loginapp.data.UserPagingSource

interface UserRepository {
    fun getUserPagingSource(): UserPagingSource
}