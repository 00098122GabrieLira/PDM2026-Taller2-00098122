package com.taller2.gala00098122.ui.screens.restaurantScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taller2.gala00098122.scaffold.AppScaffold
import com.taller2.gala00098122.ui.screens.restaurantScreen.components.CategoryHeader
import com.taller2.gala00098122.ui.screens.restaurantScreen.components.RestaurantItem

@Composable
fun RestaurantScreen(
  navigateToDishes: (Int) -> Unit,
  navigateToSearch: () -> Unit,
  viewModel: RestaurantViewModel = viewModel()
) {
  val loading by viewModel.loading.collectAsState()
  val restaurantsByCategory by viewModel.restaurantsByCategory.collectAsState()
  
  AppScaffold(
    title = "FoodSpot",
    actions = {
      IconButton(onClick = { navigateToSearch() }) {
        Icon(
          Icons.Default.Search,
          contentDescription = "Buscar",
          tint = Color.White
        )
      }
    }
  ) { padding ->
    when {
      loading -> {
        CircularProgressIndicator(
          modifier = Modifier
            .padding(padding)
        )
      }
      
      restaurantsByCategory.isEmpty() -> {
        Text(
          text = "No hay restaurantes para mostrar",
          modifier = Modifier.padding(padding),
          color = Color.White
        )
      }
      
      else -> {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
          restaurantsByCategory.forEach { (category, restaurantList) ->
            CategoryHeader(category = category)
            
            LazyRow(
              modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
              horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
              items(restaurantList) { restaurant ->
                RestaurantItem(
                  restaurant = restaurant,
                  onClick = { navigateToDishes(restaurant.id) }
                )
              }
            }
          }
        }
      }
    }
  }
}