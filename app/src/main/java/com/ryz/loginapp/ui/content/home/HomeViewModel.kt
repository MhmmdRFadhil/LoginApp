package com.ryz.loginapp.ui.content.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ryz.loginapp.common.UserViewState
import com.ryz.loginapp.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UserRepositoryImpl) : ViewModel() {
    private val _user = MutableStateFlow<UserViewState>(UserViewState.Loading)
    val user: StateFlow<UserViewState> get() = _user

    fun getUser() {
        viewModelScope.launch {
            try {
                Pager(
                    config = PagingConfig(pageSize = 6),
                    pagingSourceFactory = { repository.getUserPagingSource() }
                ).flow.cachedIn(viewModelScope).collectLatest {
                    _user.value = UserViewState.Success(it)
                }
            } catch (ex: Exception) {
                _user.value = UserViewState.Error(ex)
            }
        }
    }
}