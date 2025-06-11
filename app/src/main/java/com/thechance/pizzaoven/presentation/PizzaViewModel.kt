package com.thechance.pizzaoven.presentation

import androidx.lifecycle.ViewModel
import com.thechance.pizzaoven.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel : ViewModel(), PizzaInteractionHandler {

    private val _state = MutableStateFlow(PizzaState())
    val state = _state.asStateFlow()

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        _state.update {
            it.copy(
                ingredients = DummyDataSource.ingredient,
                pizzaTypes = DummyDataSource.pizzaTypesRes.map {
                    PizzaType(
                        imageRes = it,
                        currentIngredients = emptyList()
                    )
                }
            )
        }
    }

    override fun onBackButtonClick() {
        /*TODO: Not required in task */
    }

    override fun onFavoriteButtonClick() {
        _state.update {
            it.copy(
                isFavorite = !it.isFavorite
            )
        }
    }

    override fun onPizzaSizeButtonClick(pizzaSize: PizzaSize) {
        _state.update {
            it.copy(
                pizzaSize = pizzaSize
            )
        }
    }

    override fun onIngredientButtonClick(chosenIngredient: Ingredient, typeIndex: Int) {
        _state.update { st ->
            if (st.pizzaTypes[typeIndex].currentIngredients.find { it.name == chosenIngredient.name } != null) {
                // Exist
                st.copy(
                    pizzaTypes = st.pizzaTypes.mapIndexed { index, pizzaType ->
                        if (index == typeIndex) {
                            pizzaType.copy(
                                currentIngredients = pizzaType.currentIngredients.filter { it.name != chosenIngredient.name }
                            )
                        } else {
                            pizzaType
                        }
                    }
                )
            } else {
                // Not exist
                st.copy(
                    pizzaTypes = st.pizzaTypes.mapIndexed { index, pizzaType ->
                        if (index == typeIndex) {
                            pizzaType.copy(
                                currentIngredients = pizzaType.currentIngredients + chosenIngredient
                            )
                        } else {
                            pizzaType
                        }
                    }
                )
            }
        }
    }


    override fun onAddToCartButtonClick() {
        /*TODO: Not required in task */
    }
}