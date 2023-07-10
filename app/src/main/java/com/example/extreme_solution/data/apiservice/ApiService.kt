package com.example.extreme_solution.data.apiservice

import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.entities.products.ProductsList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): Response<ProductsList>
    @GET("products/1")
    suspend fun getProductDetails(): Response<ProductDetailsEntity>



}