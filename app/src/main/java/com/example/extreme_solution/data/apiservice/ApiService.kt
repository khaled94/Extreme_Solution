package com.example.extreme_solution.data.apiservice

import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.categories.CategoriesEntity
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): Response<List<DomainProduct>>
    @GET("products/{productId}")
    suspend fun getProductDetails(@Path("productId") productId: Int): Response<ProductDetailsEntity>
    @GET("products/categories")
    suspend fun getCategories():Response<CategoriesEntity>

}