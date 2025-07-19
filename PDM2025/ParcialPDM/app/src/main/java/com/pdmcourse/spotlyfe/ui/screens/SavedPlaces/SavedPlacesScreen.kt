package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.ui.layout.CustomFloatingButton
import com.pdmcourse.spotlyfe.ui.layout.CustomTopBar
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel

@Composable
fun SavedPlacesScreen(
  viewModel: SavedPlacesViewModel,
  onNavigateToAddPlace: () -> Unit
) {
  val places by viewModel.places.collectAsState()


  val initialPosition = places.firstOrNull()?.let {
    LatLng(it.latitude, it.longitude)
  } ?: LatLng(13.679024407659101, -89.23578718993471) // UCA

  val cameraPositionState = rememberCameraPositionState {
    position = CameraPosition.fromLatLngZoom(initialPosition, 16f)
  }

  var uiSettings by remember {
    mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
  }
  var properties by remember {
    mutableStateOf(MapProperties(mapType = MapType.HYBRID))
  }


  LaunchedEffect(Unit) {
    viewModel.loadPlaces()
  }

  Scaffold(
    topBar = { CustomTopBar() },
    floatingActionButton = {
      CustomFloatingButton(onClick = onNavigateToAddPlace)
    }
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
      ) {
        places.forEach { place ->
          Marker(
            state = MarkerState(position = LatLng(place.latitude, place.longitude)),
            title = place.name,
            snippet = place.remark
          )
        }
      }
    }
  }
}