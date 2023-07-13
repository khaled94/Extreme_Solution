package com.example.extreme_solution.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.extreme_solution.data.model.DataRating

@Entity(tableName = "Products")
data class ProductEntityDB (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null,

    @ColumnInfo(name = "Title")
    var title: String,

    @ColumnInfo(name = "Category")
    var category: String,

    @ColumnInfo(name = "Description")
    val description: String,

    @ColumnInfo(name = "Image")
    val image: String,

    @ColumnInfo(name = "Price")
    val price: Double,

    @ColumnInfo(name = "Rating Count")
    val ratingCount: Int,

    @ColumnInfo(name = "Rating Rate")
    val ratingRate: Double

)