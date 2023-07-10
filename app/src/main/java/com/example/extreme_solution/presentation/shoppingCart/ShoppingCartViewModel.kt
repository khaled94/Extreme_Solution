package com.example.extreme_solution.presentation.shoppingCart

import com.example.extreme_solution.domain.useCases.GetAllProductsUseCase
import javax.inject.Inject

class ShoppingCartViewModel @Inject constructor(private val getAllProductsUseCase: GetAllProductsUseCase)  {
}