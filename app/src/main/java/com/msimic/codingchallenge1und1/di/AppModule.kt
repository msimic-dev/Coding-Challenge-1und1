package com.msimic.codingchallenge1und1.di

import com.msimic.codingchallenge1und1.data.repository.SalesmanRepository
import com.msimic.codingchallenge1und1.data.repository.SalesmanRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @IODispatcher
    @Provides
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun bindSalesmanRepositoryImpl(
        @IODispatcher dispatcher: CoroutineDispatcher
    ): SalesmanRepository = SalesmanRepositoryImpl(dispatcher)
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IODispatcher