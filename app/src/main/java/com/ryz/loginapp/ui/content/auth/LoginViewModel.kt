package com.ryz.loginapp.ui.content.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryz.loginapp.common.ErrorHelper
import com.ryz.loginapp.common.Resource
import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.data.remote.response.LoginResponse
import com.ryz.loginapp.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private val _login = MutableLiveData<Resource<LoginResponse>>()
    val login: LiveData<Resource<LoginResponse>> = _login

    fun getLoginToken() = repository.getLoginToken()

    fun insertToken(token: String) = viewModelScope.launch {
        repository.insertToken(token)
    }

    fun login(loginEntity: LoginEntity) = viewModelScope.launch {
        repository.login(loginEntity).onStart {
            _login.postValue(Resource.Loading())
        }.catch { exception ->
            val errorMessage = ErrorHelper.getErrorMessage(exception)
            _login.postValue(Resource.Error(errorMessage))
        }.collect { result ->
            _login.postValue(Resource.Success(result))
        }
    }
}