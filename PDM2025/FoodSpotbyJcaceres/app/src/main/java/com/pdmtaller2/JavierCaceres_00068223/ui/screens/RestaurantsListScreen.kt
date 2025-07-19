package com.pdmtaller2.JavierCaceres_00068223.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.pdmtaller2.JavierCaceres_00068223.data.dummy.restaurants
import com.pdmtaller2.JavierCaceres_00068223.data.model.Restaurant
import com.pdmtaller2.JavierCaceres_00068223.ui.components.RestaurantCard

@Composable
fun RestaurantsListScreen(
    onRestaurantClick : (Int) -> Unit = {}

) {
    val groupedCategories = restaurants
        .flatMap { restaurant -> restaurant.categories.map { it to restaurant } }
        .groupBy({ it.first }, { it.second })

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {
        items(groupedCategories.entries.toList()) { (category, restaurantList) ->
            Text(
                text = category,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(restaurantList.distinctBy { it.id }) { restaurant ->
                    RestaurantCard(restaurant){
                        onRestaurantClick(restaurant.id)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RestaurantsListScreenPreview() {
    RestaurantsListScreen()
}
