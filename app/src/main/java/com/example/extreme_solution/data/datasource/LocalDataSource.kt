package com.example.extreme_solution.data.datasource

import com.example.extreme_solution.data.db.ProductDao
import com.example.extreme_solution.data.db.ProductMapperDB
import javax.inject.Inject

class LocalDataSource @Inject constructor
    (
    private val productDao: ProductDao,
    private val ProductMapperDB: ProductMapperDB = ProductMapperDB()
) : DataSource {



}