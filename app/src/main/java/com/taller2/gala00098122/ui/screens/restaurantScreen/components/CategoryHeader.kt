package com.taller2.gala00098122.ui.screens.restaurantScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryHeader(
  category: String,
  modifier: Modifier = Modifier
) {
  Text(
    text = category,
    modifier = modifier
      .fillMaxWidth()
      .padding(vertical = 8.dp, horizontal = 4.dp),
    style = MaterialTheme.typography.titleLarge.copy(
      fontWeight = FontWeight.Bold,
      fontSize = 22.sp
    ),
    color = Color.White
  )
}