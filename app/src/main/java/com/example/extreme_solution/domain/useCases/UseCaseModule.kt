package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllProductsUseCase(repository: Repository): ProductUseCase {
        return ProductUseCaseImpl(repository)
    }
    @Provides
    @Singleton
    fun provideProductDetailsUseCase(repository: Repository): ProductDetailsUseCase {
        return ProductDetailsUseCaseImpl(repository)
    }
    @Provides
    @Singleton
    fun provideCartUseCase(repository: Repository): CartUseCase {
        return CartUseCaseImpl(repository)
    }
}


