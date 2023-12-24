package com.ryz.loginapp.common

import androidx.paging.PagingData
import com.ryz.loginapp.data.entity.UserEntity

sealed class UserViewState {
    data object Loading : UserViewState()
    data class Success(val data: PagingData<UserEntity>) : UserViewState()
    data class Error(val error: Throwable) : UserViewState()
}