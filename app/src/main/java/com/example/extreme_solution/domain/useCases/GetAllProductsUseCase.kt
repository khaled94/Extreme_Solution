package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.entities.products.ProductsList
import com.example.extreme_solution.domain.repository.Repository

class GetAllProductsUseCase(private val repository: Repository) : UseCase<ProductsList> {
  /*  override fun invoke(): Flow<DataState<ProductsList>> {
        return
    }*/
}