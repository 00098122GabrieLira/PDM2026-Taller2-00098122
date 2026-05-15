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
          }
        )
      }
      entry<Routes.Dishes> { key ->
        DishScreen(
          restaurantId = key.restaurantId,
          navigateBack = { backStack.removeLastOrNull() }
        )
      }
      entry<Routes.Search>{key ->
        SearchScreen(
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