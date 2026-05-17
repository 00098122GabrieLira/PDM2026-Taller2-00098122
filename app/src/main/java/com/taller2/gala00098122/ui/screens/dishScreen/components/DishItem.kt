package com.taller2.gala00098122.ui.screens.dishScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.taller2.gala00098122.model.Dish

@Composable
fun DishItem(
  dish: Dish,
  onAddToCart: (String) -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth(),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.White
    )
  ) {
    Row(modifier = Modifier.padding(12.dp)) {
      AsyncImage(
        model = dish.imageUrl,
        contentDescription = dish.name,
        modifier = Modifier
          .size(width = 80.dp, height = 120.dp)
          .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
      )
      Spacer(modifier = Modifier.width(12.dp))
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(
          10.dp,
          alignment = Alignment.CenterVertically
        )
      ) {
        Text(
          text = dish.name,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis
        )
        
        Text(
          text = dish.description,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Button(
          onClick = { onAddToCart(dish.name) },
          colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
          )
        ) {
          Icon(
            Icons.Default.Add,
            contentDescription = "Agregar",
            tint = Color.White
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(text = "Agregar al carrito")
        }
      }
    }
  }
}
