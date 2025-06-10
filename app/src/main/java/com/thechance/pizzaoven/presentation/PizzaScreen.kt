package com.thechance.pizzaoven.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PizzaScreen(
    state: PizzaState,
    interactionHandler: PizzaInteractionHandler,
    modifier: Modifier = Modifier
) {

}

@Preview(showSystemUi = true)
@Composable
private fun PreviewPizzaScreen() {
    PizzaScreen(
        state = PizzaState(),
        interactionHandler = DummyInteractionHandler
    )
}

object DummyInteractionHandler : PizzaInteractionHandler {
    override fun onBackButtonClick() {
        TODO("Not yet implemented")
    }

    override fun onFavoriteButtonClick() {
        TODO("Not yet implemented")
    }

    override fun onPizzaSizeButtonClick(pizzaSize: PizzaSize) {
        TODO("Not yet implemented")
    }

    override fun onIngredientButtonClick(ingredient: Ingredient) {
        TODO("Not yet implemented")
    }

    override fun onAddToCartButtonClick() {
        TODO("Not yet implemented")
    }

}