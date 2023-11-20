package com.msimic.codingchallenge1und1.data.repository

import com.msimic.codingchallenge1und1.data.model.Salesman
import com.msimic.codingchallenge1und1.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SalesmanRepositoryImpl @Inject constructor(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : SalesmanRepository {
    private val activeSalesmen: List<Salesman> = listOf(
        Salesman(name = "Artem Titarenko", areas = listOf("76133")),
        Salesman(name = "Bernd Schmitt", areas = listOf("7619*")),
        Salesman(name = "Chris Krapp", areas = listOf("762*")),
        Salesman(name = "Alex Uber", areas = listOf("86*")),
        Salesman(name = "Homer Simpson", areas = listOf("8914*", "8916*")),
    )

    override fun getSalesmen(): Flow<List<Salesman>> = flow {
        delay(1000)
        withContext(ioDispatcher) {
            emit(activeSalesmen)
        }
    }
}