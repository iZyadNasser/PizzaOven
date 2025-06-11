package com.thechance.pizzaoven.presentation

import androidx.annotation.DrawableRes

data class PizzaState(
    @DrawableRes val pizzaTypesRes: List<Int> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize.MEDIUM,
    val ingredients: List<Ingredient> = emptyList(),
    val isFavorite: Boolean = true,
)

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE
}

data class Ingredient(
    val name: String,
    val isPut: Boolean,
    @DrawableRes val imagesRes: List<Int>
)
