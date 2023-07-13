package com.example.extreme_solution.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.useCases.ProductUseCase
import com.example.extreme_solution.presentation.models.PresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val productUseCase: ProductUseCase) :
    ViewModel() {
    private val presentationMapper = PresentationMapper()
     val productList = MutableLiveData<DomainDataState<List<DomainProduct>>>()
    fun getAllProducts() {
        viewModelScope.launch {
            productUseCase.getProducts().collect { dataState ->
                productList.postValue(dataState)
            }
        }
    }
}
