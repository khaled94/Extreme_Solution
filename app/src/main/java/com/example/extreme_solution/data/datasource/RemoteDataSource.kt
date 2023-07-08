package com.example.extreme_solution.data.datasource

import com.example.extreme_solution.data.apiservice.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor
    (private val serviceApi: ApiService) : DataSource {

}