package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor(private val repository: Repository) : CartUseCase{
    override fun getProductsFromDB(): Flow<List<ProductDetailsEntity>> {
        return repository.getProductsFromDB()
    }

}