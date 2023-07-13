package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(private val repository: Repository): ProductUseCase {
    override suspend fun getProducts(): Flow<DomainDataState<List<DomainProduct>>> {
        return repository.getAllProducts()
    }

}
