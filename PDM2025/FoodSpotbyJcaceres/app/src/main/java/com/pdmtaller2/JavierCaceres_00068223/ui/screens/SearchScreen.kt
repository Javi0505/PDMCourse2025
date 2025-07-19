package com.pdmtaller2.JavierCaceres_00068223.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.pdmtaller2.JavierCaceres_00068223.data.dummy.restaurants

@Composable
fun SearchScreen(onRestaurantClick: (Int) -> Unit) {
    var query by remember { mutableStateOf(TextFieldValue("")) }

    val results = remember(query.text) {
        val queryCapsLk = query.text.trim().lowercase()
        if (queryCapsLk.isEmpty()) return@remember emptyList()
        restaurants.filter { restaurant ->
            restaurant.name.lowercase().contains(queryCapsLk) ||
                    restaurant.categories.any { it.lowercase().contains(queryCapsLk) } ||
                    restaurant.menu.any { it.name.lowercase().contains(queryCapsLk) }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar restaurante, platillo o categoría") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (results.isEmpty()) {
            Text("No se encontraron resultados", color = Color.Gray)
        } else {
            LazyColumn {
                items(results.distinctBy { it.id }) { restaurant ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onRestaurantClick(restaurant.id) }
                    ) {
                        Row(modifier = Modifier.padding(12.dp)) {
                            Image(
                                painter = rememberAsyncImagePainter(restaurant.imageUrl),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(restaurant.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
