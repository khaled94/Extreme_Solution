package com.example.extreme_solution.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(data: ProductEntityDB) : Long

    @Query("SELECT * from Products")
    fun getAllProducts(): Flow<List<ProductEntityDB>>

    @Query("DELETE FROM Products")
    fun nukeTable()

}