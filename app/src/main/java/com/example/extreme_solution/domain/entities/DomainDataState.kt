package com.example.extreme_solution.domain.entities

sealed class DomainDataState<out T> {

    /**
     * A generic data class to wrap the succeeded data result.
     *
     * @param data the result data
     */
    data class Success<out T>(val data: T) : DomainDataState<T>()

    /**
     * A data class to wrap the fail exception result.
     *
     * @param exception the exception result
     */
    data class Error(val exception: Exception) : DomainDataState<Nothing>()

    /**
     * A Nothing object that emits the loading state.
     */
    object Loading : DomainDataState<Nothing>()

    /**
     * A Nothing object that emits the empty result state,
     * we use this if the request or the query succeeded but with empty results.
     */
    object Empty : DomainDataState<Nothing>()
}
