package com.thechance.pizzaoven.presentation

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp

data class PizzaState(
    val pizzaTypes: List<PizzaType> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize.MEDIUM,
    val ingredients: List<Ingredient> = emptyList(),
    val isFavorite: Boolean = true,
)

data class PizzaType(
    @DrawableRes val imageRes: Int,
    val currentIngredients: List<Ingredient>,
)

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE
}

data class Ingredient(
    val name: String,
    @DrawableRes val imagesRes: List<Int>,
)