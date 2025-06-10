package com.thechance.pizzaoven.di

import com.thechance.pizzaoven.presentation.PizzaViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::PizzaViewModel)
}