package com.thechance.pizzaoven.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.pizzaoven.R
import com.thechance.pizzaoven.presentation.components.applyIf
import com.thechance.pizzaoven.presentation.components.dropShadow

@Composable
fun PizzaScreen(
    state: PizzaState,
    interactionHandler: PizzaInteractionHandler,
    modifier: Modifier = Modifier
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val pagerState = rememberPagerState { state.pizzaTypesRes.size }
    val scrollState = rememberScrollState()

    val animatedPizzaSize by animateDpAsState(
        targetValue = when (state.pizzaSize) {
            PizzaSize.SMALL -> 180.dp
            PizzaSize.MEDIUM -> 190.dp
            PizzaSize.LARGE -> 200.dp
        },
        animationSpec = tween(durationMillis = 300)
    )

    val animatedPizzaSizeButton by animateDpAsState(
        targetValue = when (state.pizzaSize) {
            PizzaSize.SMALL -> (-72).dp
            PizzaSize.MEDIUM -> 0.dp
            PizzaSize.LARGE -> 72.dp
        },
        animationSpec = tween(durationMillis = 150)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 40.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back),
                tint = Color.Black.copy(alpha = 0.7f),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { interactionHandler.onBackButtonClick() }
            )

            Text(
                text = stringResource(R.string.pizza),
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp
            )

            Icon(
                imageVector = if (state.isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                contentDescription = stringResource(R.string.back),
                tint = Color.Black,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { interactionHandler.onFavoriteButtonClick() }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 40.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.im_plate),
                contentDescription = stringResource(R.string.plate),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 64.dp)

            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
            ) { index ->
                val imageRes = state.pizzaTypesRes[index]

                Box(
                    modifier = Modifier
                        .width(screenWidth),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(animatedPizzaSize)
                    )
                }
            }
        }

        Text(
            text = "$17",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 0.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 40.dp
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .offset(x = animatedPizzaSizeButton)
                    .dropShadow(
                        shape = CircleShape,
                        color = Color.Black.copy(0.25f),
                        blur = 15.dp,
                        offsetY = 6.dp,
                        offsetX = 2.dp,
                        spread = (-20).dp,
                    )
                    .padding(end = 12.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .background(
                        color = Color.White
                    )
            )
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                        .clickable { interactionHandler.onPizzaSizeButtonClick(PizzaSize.SMALL) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "S",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                }

                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                        .clickable { interactionHandler.onPizzaSizeButtonClick(PizzaSize.MEDIUM) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "M",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                        .clickable { interactionHandler.onPizzaSizeButtonClick(PizzaSize.LARGE) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "L",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
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