package com.example.extreme_solution.data.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.extreme_solution.data.db.ProductDao
import com.example.extreme_solution.data.db.ProductDatabase
import com.example.extreme_solution.data.db.ProductMapperDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): ProductDatabase {
        return Room
            .databaseBuilder(application, ProductDatabase::class.java, "ShoppingCartItems.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductDao(@NonNull database: ProductDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideProductMapperDB(): ProductMapperDB {
        return ProductMapperDB()
    }

}