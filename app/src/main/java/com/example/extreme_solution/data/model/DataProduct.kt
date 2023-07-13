package com.example.extreme_solution.data.model

data class DataProduct(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: DataRating,
    val title: String
)
