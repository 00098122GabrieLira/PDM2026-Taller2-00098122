package com.taller2.gala00098122

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.taller2.gala00098122.navegacion.RestauranteApp
import com.taller2.gala00098122.ui.theme.Taller2FoodSpotTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Taller2FoodSpotTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          RestauranteApp(
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}