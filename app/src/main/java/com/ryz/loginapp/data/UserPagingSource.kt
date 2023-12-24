package com.ryz.loginapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ryz.loginapp.data.entity.UserEntity
import com.ryz.loginapp.data.remote.retrofit.ApiService

class UserPagingSource(private val service: ApiService) : PagingSource<Int, UserEntity>() {
    override fun getRefreshKey(state: PagingState<Int, UserEntity>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserEntity> = try {
        val page = params.key ?: 1
        val response = service.getUsers(page)
        val user = response.data

        LoadResult.Page(
            data = user,
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (user.isEmpty()) null else page + 1
        )
    } catch (ex: Exception) {
        LoadResult.Error(ex)
    }
}