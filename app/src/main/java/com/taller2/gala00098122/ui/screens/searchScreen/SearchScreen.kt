package com.taller2.gala00098122.ui.screens.searchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taller2.gala00098122.scaffold.AppScaffold
import com.taller2.gala00098122.ui.screens.searchScreen.components.CustomizableSearchBar
import com.taller2.gala00098122.ui.screens.searchScreen.components.SearchRestaurantItem

@Composable
fun SearchScreen(
  navigateBack: () -> Unit,
  navigateToDishes: (Int) -> Unit,
  viewModel: SearchViewModel = viewModel()
) {
  val searchResults by viewModel.searchResults.collectAsState()
  val searchQuery by viewModel.searchQuery.collectAsState()
  val loading by viewModel.loading.collectAsState()
  
  LaunchedEffect(Unit) {
    viewModel.loadRestaurants()
  }
  
  AppScaffold(
    title = "Buscar",
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
        CircularProgressIndicator(
          modifier = Modifier.padding(padding)
        )
      }
      
      else -> {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
          CustomizableSearchBar(
            query = searchQuery,
            onQueryChange = {
              viewModel.updateSearchQuery(it)
            },
            onSearch = {
              viewModel.updateSearchQuery(it)
            },
            searchResults = emptyList(),
            onResultClick = {}
          )
          
          when {
            
            searchResults.isNotEmpty() -> {
              Text(
                text = "${searchResults.size} resultado${if (searchResults.size != 1) "s" else ""} encontrado${if (searchResults.size != 1) "s" else ""}",
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
              )
              
              LazyColumn(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
              ) {
                items(searchResults) { restaurant ->
                  SearchRestaurantItem(
                    restaurant = restaurant,
                    onClick = { navigateToDishes(restaurant.id) }
                  )
                }
              }
            }
            
            searchQuery.isNotBlank() && searchResults.isEmpty() -> {
              Column(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
              ) {
                Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "Sin resultados",
                  tint = Color.White,
                  modifier = Modifier.size(72.dp)
                )
                Text(
                  text = "No se encontraron resultados",
                  color = Color.White,
                  modifier = Modifier.padding(top = 16.dp)
                )
                
              }
            }
            
            else -> {
              Column(
                modifier = Modifier
                  .fillMaxSize()
                  .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                  5.dp,
                  alignment = Alignment.CenterVertically
                )
              ) {
                Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "Buscar",
                  tint = Color.White,
                  modifier = Modifier.size(72.dp)
                )
                Text(
                  text = "Busca restaurantes o platillos de tu preferencia",
                  color = Color.White,
                  modifier = Modifier.padding(top = 16.dp),
                  textAlign = TextAlign.Center
                )
              }
            }
          }
        }
      }
    }
  }
}