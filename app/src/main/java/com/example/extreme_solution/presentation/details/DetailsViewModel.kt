package com.example.extreme_solution.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.useCases.ProductDetailsUseCase
import com.example.extreme_solution.presentation.common.BaseViewModel
import kotlinx.coroutines.launch
import org.jsoup.Connection.Base
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val productDetailsUseCase: ProductDetailsUseCase) : BaseViewModel() {
    val productDetails = MutableLiveData<DomainDataState<ProductDetailsEntity>>()

    fun getProductDetails(productId: Int) {
        viewModelScope.launch {
            productDetailsUseCase.getProductDetails(productId).collect { dataState ->
                productDetails.postValue(dataState)
            }
        }
    }

    fun saveProductToDatabase(product:ProductDetailsEntity): Boolean {
        return productDetailsUseCase.saveProductToDatabase(product)
    }
}