package com.thechance.pizzaoven.presentation

interface PizzaInteractionHandler {

    fun onBackButtonClick()

    fun onFavoriteButtonClick()

    fun onPizzaSizeButtonClick(pizzaSize: PizzaSize)

    fun onIngredientButtonClick(ingredient: Ingredient)

    fun onAddToCartButtonClick()
}