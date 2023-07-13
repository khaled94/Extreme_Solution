package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDetailsUseCaseImpl  @Inject constructor(private val repository: Repository): ProductDetailsUseCase {
    override suspend fun getProductDetails(productId: Int): Flow<DomainDataState<ProductDetailsEntity>> {
        return repository.getProductDetails(productId)
    }

    override fun saveProductToDatabase(product:ProductDetailsEntity): Boolean {
        return repository.saveProductToDatabase(product)
    }

}