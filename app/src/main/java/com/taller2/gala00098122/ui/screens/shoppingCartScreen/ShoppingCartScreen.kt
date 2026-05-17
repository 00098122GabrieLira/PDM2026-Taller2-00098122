package com.taller2.gala00098122.ui.screens.shoppingCartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingCartScreen(
  navigateBack: () -> Unit,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(
      10.dp,
      alignment = Alignment.CenterVertically
    )
  ) {
    Text(
      text = "Aqui va el carrito",
      color = Color.Black
    )
    
    Button(
      onClick = { navigateBack() },
      colors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White
      )
    ) {
      Text(text = "Atras")
    }
  }
}