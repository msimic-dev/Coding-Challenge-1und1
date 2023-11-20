package com.msimic.codingchallenge1und1.data.repository

import com.msimic.codingchallenge1und1.data.model.Salesman
import kotlinx.coroutines.flow.Flow

interface SalesmanRepository {
    fun getSalesmen(): Flow<List<Salesman>>
}