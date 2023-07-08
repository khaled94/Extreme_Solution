package com.example.extreme_solution.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(data: List<ProductEntityDB>)

    @Query("SELECT * from Products")
    fun getAllProducts(): List<ProductEntityDB>

    @Query("DELETE FROM Products")
    fun nukeTable()

}