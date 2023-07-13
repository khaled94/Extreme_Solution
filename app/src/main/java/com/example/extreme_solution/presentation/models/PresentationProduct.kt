package com.example.extreme_solution.presentation.models

import com.example.extreme_solution.data.model.PresentationRating

data class PresentationProduct(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: PresentationRating,
    val title: String
)
