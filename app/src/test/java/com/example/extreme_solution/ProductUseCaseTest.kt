package com.example.extreme_solution

import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.products.DomainRating
import com.example.extreme_solution.domain.repository.Repository
import com.example.extreme_solution.domain.useCases.ProductUseCaseImpl
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.*

class ProductUseCaseTest {

    // Create a test product
    private val testProduct = DomainProduct(
        category = "test",
        description = "test description",
        id = 1,
        image = "test image",
        price = 9.99,
        rating = DomainRating(rate = 4.0, count = 100),
        title = "test title"
    )

    // Create a mock Repository that returns a Flow of DomainDataState.Success with the test product
    private val mockRepository = mock(Repository::class.java)
    private val testData = listOf(testProduct)

    // Create an instance of ProductUseCaseImpl using the mock repository
    private val useCase = ProductUseCaseImpl(mockRepository)

    @Test
    fun `test getProducts returns success state with data`() = runBlocking {
        doReturn(flowOf(DomainDataState.Success(testData)))
            .`when`(mockRepository)
            .getAllProducts()
        val resultFlow = useCase.getProducts()
        val result = resultFlow.first()
        assert(result is DomainDataState.Success)
        assertEquals(testData, (result as DomainDataState.Success).data)
    }
}