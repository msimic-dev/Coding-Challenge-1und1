package com.msimic.codingchallenge1und1.data.repository

import android.util.Log
import com.msimic.codingchallenge1und1.data.model.Salesman
import com.msimic.codingchallenge1und1.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SalesmanRepositoryImpl @Inject constructor(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : SalesmanRepository {
    private val allSalesmen = flowOf(
        listOf(
            Salesman(name = "Artem Titarenko", areas = listOf("76133")),
            Salesman(name = "Bernd Schmitt", areas = listOf("7619*")),
            Salesman(name = "Chris Krapp", areas = listOf("762*")),
            Salesman(name = "Alex Uber", areas = listOf("86*")),
            Salesman(name = "Homer Simpson", areas = listOf("8914*", "8916*")),
        )
    ).flowOn(ioDispatcher)

    /**
     * Get all salesmen, that work in the queried area. If query is empty return all salesmen.
     *
     * @param query representing a valid postal code expression.
     * @return a list containing all salesmen that match the query.
     */
    override fun getSalesmen(
        query: String,
    ): Flow<List<Salesman>> {
        return if (query.isNotEmpty()) {
            allSalesmen.map { salesmenList ->
                salesmenList.filter { salesman -> salesman.isResponsibleForArea(query) }
            }
        } else {
            allSalesmen
        }
    }

}