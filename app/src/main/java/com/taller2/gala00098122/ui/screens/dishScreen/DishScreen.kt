package com.taller2.gala00098122.ui.screens.dishScreen


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taller2.gala00098122.scaffold.AppScaffold
import com.taller2.gala00098122.ui.screens.dishScreen.components.DishItem
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun DishScreen(
  restaurantId: Int,
  navigateBack: () -> Unit,
  navigateToCart: () -> Unit,
  viewModel: DishViewModel = viewModel()
) {
  
  val restaurant by viewModel.restaurant.collectAsState()
  val loading by viewModel.isLoading.collectAsState()
  val context = LocalContext.current
  
  LaunchedEffect(restaurantId) {
    viewModel.loadDishes(restaurantId)
  }
  
  AppScaffold(
    navigationIcon = {
      IconButton(onClick = { navigateBack() }) {
        Icon(
          Icons.AutoMirrored.Filled.ArrowBack,
          contentDescription = "Volver",
          tint = Color.White
        )
      }
    },
    title = restaurant?.name ?: "Cargando...",
    actions = {
      IconButton(onClick = { navigateToCart() }) {
        Icon(
          Icons.Default.ShoppingCart,
          contentDescription = "Carrito de compras",
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
      
      restaurant!!.menu.isEmpty() -> {
        Text(
          text = "No hay platillos para mostrar",
          modifier = Modifier.padding(padding),
          color = Color.White
        )
      }
      
      else -> {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        ) {
          Text(
            text = restaurant!!.description,
            color = Color.White,
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
          )
          
          LazyColumn(
            modifier = Modifier
              .fillMaxWidth()
              .weight(1f).
            padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            items(restaurant!!.menu) { dish ->
              DishItem(
                dish = dish,
                onAddToCart = { dishName ->
                  Toast.makeText(
                    context,
                    "$dishName agregado al carrito",
                    Toast.LENGTH_SHORT
                  ).show()
                }
              )
              Spacer(modifier = Modifier.height(12.dp))
            }
          }
        }
      }
    }
  }
}