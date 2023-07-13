package com.example.extreme_solution.domain.entities.products

import com.example.extreme_solution.data.model.DataRating

data class DomainProduct(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: DomainRating,
    val title: String
)
