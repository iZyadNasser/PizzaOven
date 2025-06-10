package com.thechance.pizzaoven.presentation.uiModels

import androidx.annotation.DrawableRes

data class Ingredient(
    val name: String,
    @DrawableRes val imageRes: Int,
    val isPut: Boolean,
)
