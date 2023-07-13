package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    fun getProductsFromDB(): Flow<List<ProductDetailsEntity>>
}