package com.taller2.gala00098122.navegacion

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.taller2.gala00098122.navegacion.routes.Routes
import com.taller2.gala00098122.ui.screens.dishScreen.DishScreen
import com.taller2.gala00098122.ui.screens.restaurantScreen.RestaurantScreen
import com.taller2.gala00098122.ui.screens.searchScreen.SearchScreen
import com.taller2.gala00098122.ui.screens.shoppingCartScreen.ShoppingCartScreen

@Composable
fun RestauranteApp(modifier: Modifier = Modifier) {
  val backStack = rememberNavBackStack(Routes.Restaurants)
  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider = entryProvider {
      entry<Routes.Restaurants> {
        RestaurantScreen(
          navigateToDishes = { restaurantId ->
            backStack.add(Routes.Dishes(restaurantId))
          },
          navigateToSearch = { backStack.add(Routes.Search) },
        )
      }
      entry<Routes.Dishes> { key ->
        DishScreen(
          restaurantId = key.restaurantId,
          navigateBack = { backStack.removeLastOrNull() },
          navigateToCart = { backStack.add(Routes.ShoppingCart) }
        )
      }
      entry<Routes.Search> {
        SearchScreen(
          navigateBack = { backStack.removeLastOrNull() },
          navigateToDishes = { restaurantId ->
            backStack.add(Routes.Dishes(restaurantId))
          }
        )
      }
      entry<Routes.ShoppingCart> {
        ShoppingCartScreen(
          navigateBack = { backStack.removeLastOrNull() }
        )
      }
    },
    transitionSpec = {
      slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(500)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { -it },
        animationSpec = tween(500)
      )
    },
    popTransitionSpec = {
      slideInHorizontally(
        initialOffsetX = { -it },
        animationSpec = tween(500)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(500)
      )
    },
    predictivePopTransitionSpec = {
      slideInHorizontally(
        initialOffsetX = { -it },
        animationSpec = tween(250)
      ) togetherWith slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(250)
      )
    }
  )
}