package com.example.extreme_solution.presentation.models

import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.domain.entities.products.DomainRating
import com.example.extreme_solution.data.model.PresentationRating

class PresentationMapper {
    fun DomainProduct.toPresentation(): PresentationProduct {
        return PresentationProduct(
            category = this.category,
            description = this.description,
            id = this.id,
            image = this.image,
            price = this.price,
            rating = PresentationRating(this.rating.count,this.rating.rate),
            title = this.title
        )
    }

    fun DomainRating.toPresentation(): PresentationRating {
        return PresentationRating(rate = this.rate, count = this.count)
    }

}