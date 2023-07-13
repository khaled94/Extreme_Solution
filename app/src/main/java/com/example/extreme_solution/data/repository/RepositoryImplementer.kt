package com.example.extreme_solution.data.repository

import com.example.extreme_solution.data.datasource.LocalDataSource
import com.example.extreme_solution.data.datasource.RemoteDataSource
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : Repository{
    override suspend fun getAllProducts(): Flow<DomainDataState<List<DomainProduct>>> {
        return remoteDataSource.getAllProducts()
    }

    override suspend fun getProductDetails(productId: Int): Flow<DomainDataState<ProductDetailsEntity>> {
        return remoteDataSource.getProductDetails(productId)
    }

    override fun saveProductToDatabase(product:ProductDetailsEntity): Boolean {
        return localDataSource.saveProductToDatabase(product)
    }

    override fun getProductsFromDB(): Flow<List<ProductDetailsEntity>> {
        return localDataSource.getProductsFromDB()
    }
}