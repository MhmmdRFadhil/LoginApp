package com.ryz.loginapp.data.remote.response

import com.ryz.loginapp.data.entity.UserEntity

data class UserResponse(
    val page: Int,
    val data: List<UserEntity>
)
