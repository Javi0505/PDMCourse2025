package com.pdmtaller2.JavierCaceres_00068223.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String
) {
    TopAppBar(
        title = { Text(text = title) }
//    colors = TopAppBarDefaults.topAppBarColors(
//      containerColor = MaterialTheme.colorScheme.primary,
//      titleContentColor = Color.Black,
//      actionIconContentColor = Color.Black,
//      navigationIconContentColor = Color.Black,
//    )
    )
}