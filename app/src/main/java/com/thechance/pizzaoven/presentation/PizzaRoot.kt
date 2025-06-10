package com.thechance.pizzaoven.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun PizzaRoot() {
    val pizzaViewModel: PizzaViewModel = koinViewModel()
    val uiState = pizzaViewModel.state.collectAsStateWithLifecycle()

    PizzaScreen(
        state = uiState.value,
        interactionHandler = pizzaViewModel
    )
}