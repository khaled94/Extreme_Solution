package com.example.extreme_solution.domain.mappers

import com.example.extreme_solution.data.model.DataProduct
import com.example.extreme_solution.data.model.DataRating
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.products.DomainRating

class DomainMapper {
    fun DataProduct.toDomain(): DomainProduct {
        return DomainProduct(
            category = this.category,
            description = this.description,
            id = this.id,
            image = this.image,
            price = this.price,
            rating = DomainRating(this.rating.count,this.rating.rate),
            title = this.title
        )
    }

    fun DataRating.toDomain(): DomainRating {
        return DomainRating(rate = this.rate, count = this.count)
    }
}