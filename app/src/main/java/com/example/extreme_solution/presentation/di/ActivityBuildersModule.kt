package com.example.extreme_solution.presentation.di

import com.example.extreme_solution.presentation.details.DetailsFragment
import com.example.extreme_solution.presentation.details.DetailsViewModelModule
import com.example.extreme_solution.presentation.home.HomeFragment
import com.example.extreme_solution.presentation.home.HomeViewModel
import com.example.extreme_solution.presentation.shoppingCart.ShoppingCartFragment
import com.example.extreme_solution.presentation.shoppingCart.ShoppingCartViewModel
import com.example.extreme_solution.presentation.splash.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

  @ContributesAndroidInjector
  abstract fun contributeMainActivity(): MainActivity

  @ContributesAndroidInjector(modules = [HomeViewModel::class])
  abstract fun contributeHomeFragment(): HomeFragment

  @ContributesAndroidInjector(modules = [ShoppingCartViewModel::class])
  abstract fun contributeShoppingCartFragment(): ShoppingCartFragment

  @ContributesAndroidInjector(modules = [DetailsViewModelModule::class])
  abstract fun contributeDetailsFragment(): DetailsFragment




}