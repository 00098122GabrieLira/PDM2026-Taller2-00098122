package com.taller2.gala00098122.ui.screens.shoppingCartScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.taller2.gala00098122.ui.screens.shoppingCartScreen.components.ShoppingCartItem

@Composable
fun ShoppingCartScreen(
  navigateBack: () -> Unit,
  viewModel: ShoppingCartViewModel = viewModel()
) {
  val cartItems by viewModel.cartItems.collectAsState()
  val loading by viewModel.loading.collectAsState()
  val context = LocalContext.current
  
  AppScaffold(
    title = "Mi Carrito",
    navigationIcon = {
      IconButton(onClick = { navigateBack() }) {
        Icon(
          Icons.AutoMirrored.Filled.ArrowBack,
          contentDescription = "Volver",
          tint = Color.White
        )
      }
    }
  ) { padding ->
    when {
      loading -> {
        CircularProgressIndicator(modifier = Modifier.padding(padding))
      }
      
      cartItems.isEmpty() -> {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          
          Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Carrito vacio",
            tint = Color.White,
            modifier = Modifier.size(72.dp)
          )
          
          Text(
            text = "Tu carrito está vacío",
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
          )
          
        }
      }
      
      else -> {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
          LazyColumn(
            modifier = Modifier
              .fillMaxWidth()
              .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            items(cartItems) { cartItem ->
              ShoppingCartItem(
                cartItem = cartItem,
                onQuantityChange = { newQuantity ->
                  viewModel.updateQuantity(cartItem.dish.id, newQuantity)
                },
                onRemove = {
                  viewModel.removeFromCart(cartItem.dish.id)
                }
              )
            }
          }
          
          Button(
            onClick = {
              viewModel.clearCart()
              Toast.makeText(
                context,
                "Pedido completado con exito",
                Toast.LENGTH_SHORT
              ).show()
            },
            colors = ButtonDefaults.buttonColors(
              containerColor = Color.Blue,
              contentColor = Color.White
            ),
            modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp)
          ) {
            Icon(
              Icons.Default.Done,
              contentDescription = "Completado",
              tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Completar pedido")
          }
        }
      }
    }
  }
}