package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.entities.products.DomainProduct
import kotlinx.coroutines.flow.Flow

interface ProductDetailsUseCase {
    suspend fun getProductDetails(productId: Int): Flow<DomainDataState<ProductDetailsEntity>>
    fun saveProductToDatabase(product:ProductDetailsEntity): Boolean
}