package com.example.extreme_solution.presentation.shoppingCart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.useCases.CartUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShoppingCartViewModel @Inject constructor(private val cartUseCase: CartUseCase) :
    ViewModel() {
    val productList = MutableLiveData<List<ProductDetailsEntity>>()
    fun getAllProducts() {
        viewModelScope.launch {
            cartUseCase.getProductsFromDB().collect { data->
                productList.postValue(data)
            }
        }
    }
}