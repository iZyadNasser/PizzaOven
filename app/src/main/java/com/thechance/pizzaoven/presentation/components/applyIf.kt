package com.thechance.pizzaoven.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.applyIf(condition: Boolean, modifier: @Composable Modifier.() -> Modifier): Modifier {
    return if (condition) {
        then(modifier())
    } else {
        this
    }
}