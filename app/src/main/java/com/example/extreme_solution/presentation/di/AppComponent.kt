package com.example.extreme_solution.presentation.di

import android.app.Application
import com.example.extreme_solution.data.di.DataBaseModule
import com.example.extreme_solution.data.di.NetworkModule
import com.example.extreme_solution.presentation.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactory::class,
        ActivityBuildersModule::class,
        NetworkModule::class,
        DataBaseModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}