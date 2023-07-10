package com.example.extreme_solution.presentation.home

import com.example.extreme_solution.domain.useCases.GetAllProductsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getAllProductsUseCase: GetAllProductsUseCase) {
}