package com.ryz.loginapp.di

import com.ryz.loginapp.data.local.dao.UserDao
import com.ryz.loginapp.data.remote.retrofit.ApiService
import com.ryz.loginapp.data.repository.LoginRepository
import com.ryz.loginapp.data.repository.LoginRepositoryImpl
import com.ryz.loginapp.data.repository.UserRepository
import com.ryz.loginapp.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun injectRepository(service: ApiService, dao: UserDao): LoginRepository =
        LoginRepositoryImpl(service, dao)

    @Singleton
    @Provides
    fun injectUserRepository(service: ApiService): UserRepository = UserRepositoryImpl(service)
}