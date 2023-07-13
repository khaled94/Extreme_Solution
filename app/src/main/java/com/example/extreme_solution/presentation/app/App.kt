package com.example.extreme_solution.presentation.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.example.extreme_solution.presentation.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}