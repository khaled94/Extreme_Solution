package com.example.extreme_solution.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntityDB (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null,

    @ColumnInfo(name = "MedicineName")
    var ProductName: String,

)