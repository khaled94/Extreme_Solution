package com.example.extreme_solution.presentation.details

import com.example.extreme_solution.domain.useCases.GetAllProductsUseCase
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val getDetailsUseCase: GetAllProductsUseCase) {
}