package com.thechance.pizzaoven.presentation

import androidx.annotation.DrawableRes
import com.thechance.pizzaoven.presentation.uiModels.Ingredient
import com.thechance.pizzaoven.presentation.uiModels.PizzaSize

data class PizzaState(
    @DrawableRes val pizzaTypeRes: Int,
    val pizzaSize: PizzaSize,
    val ingredients: List<Ingredient>,
)
