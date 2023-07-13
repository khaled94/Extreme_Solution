package com.example.extreme_solution.data.db

import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.domain.entities.productDetails.Rating
import com.example.extreme_solution.domain.entities.products.DomainProduct


class ProductMapperDB {
    fun mapFromDBEntityToDomainProduct(entity: ProductEntityDB): ProductDetailsEntity {
        return ProductDetailsEntity(
            entity.category,
            entity.description,
            entity.id!!,
            entity.image,
            entity.price,
            Rating(entity.ratingCount, entity.ratingRate),
            entity.title
        )
    }

    fun mapFromDomainProductToDBEntity(product: ProductDetailsEntity): ProductEntityDB {
        return ProductEntityDB(
            product.id,
            product.title,
            product.category,
            product.description,
            product.image,
            product.price,
            product.rating.count,
            product.rating.rate
        )
    }
}



