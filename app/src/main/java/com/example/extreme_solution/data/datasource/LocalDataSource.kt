package com.example.extreme_solution.data.datasource

import com.example.extreme_solution.data.db.ProductDao
import com.example.extreme_solution.data.db.ProductMapperDB
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject constructor
    (
    private val productDao: ProductDao,
    private val productMapperDB: ProductMapperDB
) : DataSource {
    fun saveProductToDatabase(product:ProductDetailsEntity): Boolean {
        val product = productMapperDB.mapFromDomainProductToDBEntity(product)
        val rowId = productDao.insertProduct(product)
        return rowId >= 0
    }

    fun getProductsFromDB(): Flow<List<ProductDetailsEntity>> {
        return productDao.getAllProducts()
            .map { dbProducts -> dbProducts.map { productMapperDB.mapFromDBEntityToDomainProduct(it) }
            }
    }


}