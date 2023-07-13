package com.example.extreme_solution.presentation.details

import androidx.lifecycle.ViewModel
import com.example.extreme_solution.presentation.di.ViewModelKey
import com.example.extreme_solution.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailsViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindsDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel
}