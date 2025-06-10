package com.thechance.pizzaoven.presentation

import androidx.lifecycle.ViewModel
import com.thechance.pizzaoven.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel: ViewModel() {

    private val _state = MutableStateFlow(PizzaState())
    val state = _state.asStateFlow()

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        _state.update {
            it.copy(
                ingredients = DummyDataSource.ingredient
            )
        }
    }
}