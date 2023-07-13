package com.example.extreme_solution.presentation.shoppingCart

import androidx.lifecycle.ViewModel
import com.example.extreme_solution.presentation.details.DetailsViewModel
import com.example.extreme_solution.presentation.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class ShoppingCartViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(ShoppingCartViewModel::class)
    abstract fun bindShoppingCartViewModel(shoppingCartViewModel: ShoppingCartViewModel): ViewModel

}