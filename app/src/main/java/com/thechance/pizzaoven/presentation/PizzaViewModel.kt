package com.thechance.pizzaoven.presentation

import androidx.lifecycle.ViewModel
import com.thechance.pizzaoven.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel: ViewModel(), PizzaInteractionHandler {

    private val _state = MutableStateFlow(PizzaState())
    val state = _state.asStateFlow()

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        _state.update {
            it.copy(
                ingredients = DummyDataSource.ingredient,
                pizzaTypesRes = DummyDataSource.pizzaTypesRes
            )
        }
    }

    override fun onBackButtonClick() {
        TODO("Not yet implemented")
    }

    override fun onFavoriteButtonClick() {
        TODO("Not yet implemented")
    }

    override fun onPizzaSizeButtonClick(pizzaSize: PizzaSize) {
        _state.update {
            it.copy(
                pizzaSize = pizzaSize
            )
        }
    }

    override fun onIngredientButtonClick(ingredient: Ingredient) {
        TODO("Not yet implemented")
    }

    override fun onAddToCartButtonClick() {
        TODO("Not yet implemented")
    }
}