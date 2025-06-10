package com.thechance.pizzaoven.presentation

import androidx.annotation.DrawableRes
import com.thechance.pizzaoven.R

data class PizzaState(
    @DrawableRes val pizzaTypeRes: Int = R.drawable.im_bread_1,
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
