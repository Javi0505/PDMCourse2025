package com.pdmtaller2.JavierCaceres_00068223.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.pdmtaller2.JavierCaceres_00068223.data.dummy.restaurants

@Composable
fun RestaurantDetailScreen(restaurantId: Int) {
    val restaurant = restaurants.firstOrNull { it.id == restaurantId }
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    if (restaurant == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Restaurante no encontrado", style = MaterialTheme.typography.titleLarge)
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFF121212))
    ) {
        Image(
            painter = rememberAsyncImagePainter(restaurant.imageUrl),
            contentDescription = restaurant.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = restaurant.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Categorías: ${restaurant.categories.joinToString()}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color.DarkGray)

            Text(
                text = "Platillos disponibles",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            restaurant.menu.forEach { dish ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(dish.imageUrl),
                            contentDescription = dish.name,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = dish.name,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = dish.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.LightGray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Agregar")
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
