package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.DomainDataState
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {
    suspend fun getProducts(): Flow<DomainDataState<List<DomainProduct>>>
}