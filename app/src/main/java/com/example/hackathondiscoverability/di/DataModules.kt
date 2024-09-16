package com.example.hackathondiscoverability.di

import com.example.hackathondiscoverability.data.AppRepository
import com.example.hackathondiscoverability.data.DefaultAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAppRepository(
        defaultAppRepository: DefaultAppRepository
    ): AppRepository
}