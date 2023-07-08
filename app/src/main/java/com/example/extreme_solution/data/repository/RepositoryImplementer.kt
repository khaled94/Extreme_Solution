package com.example.extreme_solution.data.repository

import com.example.extreme_solution.data.datasource.LocalDataSource
import com.example.extreme_solution.data.datasource.RemoteDataSource
import com.example.extreme_solution.domain.repository.Repository
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : Repository{
}