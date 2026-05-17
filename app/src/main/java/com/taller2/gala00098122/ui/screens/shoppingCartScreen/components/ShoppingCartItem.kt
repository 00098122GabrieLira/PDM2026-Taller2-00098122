package com.taller2.gala00098122.ui.screens.shoppingCartScreen.components

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
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
import com.taller2.gala00098122.model.ShoppingCart
import androidx.compose.material3.Icon

@Composable
fun ShoppingCartItem(
  cartItem: ShoppingCart,
  onQuantityChange: (Int) -> Unit,
  onRemove: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 8.dp, vertical = 4.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.White
    )
  ) {
    Row(
      modifier = Modifier.padding(12.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      
      AsyncImage(
        model = cartItem.dish.imageUrl,
        contentDescription = cartItem.dish.name,
        modifier = Modifier
          .size(70.dp, 70.dp)
          .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
      )
      
      Spacer(modifier = Modifier.width(12.dp))
      
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        Text(
          text = cartItem.dish.name,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          color = Color.Black
        )
        
        Text(
          text = cartItem.dish.description,
          style = MaterialTheme.typography.bodySmall,
          color = Color.DarkGray,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis
        )
        
        Text(
          text = "Restaurante: ${cartItem.restaurantName}",
          style = MaterialTheme.typography.bodySmall,
          color = Color.Gray,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
      
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        
        Text(
          text = "Cantidad: ${cartItem.quantity}",
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          color = Color.Black
        )
        
        IconButton(
          onClick = {
            if (cartItem.quantity > 1) {
              onQuantityChange(cartItem.quantity - 1)
            } else {
              onRemove()
            }
          },
          modifier = Modifier.size(32.dp)
        ) {
          Icon(
            Icons.Default.Remove,
            contentDescription = "Disminuir",
            tint = Color(0xFF338046)
          )
        }
        
        IconButton(
          onClick = { onRemove() },
          modifier = Modifier.size(32.dp)
        ) {
          Icon(
            Icons.Default.Delete,
            contentDescription = "Disminuir",
            tint = Color.Red
          )
        }
      }
    }
  }
}