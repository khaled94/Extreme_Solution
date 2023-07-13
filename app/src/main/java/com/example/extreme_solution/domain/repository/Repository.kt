package com.example.extreme_solution.domain.repository

import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllProducts() : Flow<DomainDataState<List<DomainProduct>>>
    suspend fun getProductDetails(productId: Int) :  Flow<DomainDataState<ProductDetailsEntity>>
    fun saveProductToDatabase(product:ProductDetailsEntity): Boolean
    fun getProductsFromDB(): Flow<List<ProductDetailsEntity>>


}