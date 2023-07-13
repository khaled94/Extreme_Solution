package com.example.extreme_solution.data.datasource

import com.example.extreme_solution.data.apiservice.ApiService
import com.example.extreme_solution.domain.entities.DomainDataState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor
    (private val serviceApi: ApiService) : DataSource {
    suspend fun getAllProducts() = flow {
        emit(DomainDataState.Loading)
        try {
            val details = serviceApi.getAllProducts()
            if (details.isSuccessful) {
                emit(DomainDataState.Success(details.body()!!))
            }
        } catch (e: Exception) {
            emit(DomainDataState.Error(e))
        }
    }

    suspend fun getProductDetails(productId : Int) = flow {
        emit(DomainDataState.Loading)
        try {
            val details = serviceApi.getProductDetails(productId)
            if (details.isSuccessful) {
                emit(DomainDataState.Success(details.body()!!))
            }
        } catch (e: Exception) {
            emit(DomainDataState.Error(e))
        }
    }

}