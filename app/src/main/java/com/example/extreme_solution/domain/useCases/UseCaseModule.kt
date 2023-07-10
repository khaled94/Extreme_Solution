package com.example.extreme_solution.domain.useCases

import com.example.extreme_solution.data.datasource.LocalDataSource
import com.example.extreme_solution.data.datasource.RemoteDataSource
import com.example.extreme_solution.data.repository.RepositoryImplementer
import com.example.extreme_solution.domain.repository.Repository
import dagger.Provides

class UseCaseModule {
    @Provides
    fun providesUseCase(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): Repository =
        RepositoryImplementer(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
}