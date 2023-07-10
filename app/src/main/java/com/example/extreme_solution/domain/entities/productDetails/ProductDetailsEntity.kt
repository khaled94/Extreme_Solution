package com.example.extreme_solution.domain.entities.productDetails

data class ProductDetailsEntity(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Int,
    val rating: Rating,
    val title: String
)