package com.pdmcourse.spotlyfe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmcourse.spotlyfe.SpotLyfeApplication
import com.pdmcourse.spotlyfe.ui.screens.AddPlace.AddPlaceScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesScreen
import com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.SavedPlacesViewModel
import com.pdmcourse.spotlyfe.ui.screens.AddPlace.AddPlaceViewModel

@Composable
fun MainNavigation(navController: NavHostController) {

  val context = LocalContext.current.applicationContext as SpotLyfeApplication
  val viewModel = remember {
    SavedPlacesViewModel(context.appProvider.providePlaceRepository())
  }
  val addPlaceViewModel = remember {
    AddPlaceViewModel(context.appProvider.providePlaceRepository())
  }

  NavHost(navController = navController, startDestination = SavedPlacesScreenNavigation) {

    composable<SavedPlacesScreenNavigation> {
      SavedPlacesScreen(
        viewModel = viewModel,
        onNavigateToAddPlace = {
          navController.navigate(AddPlaceScreenNavigation)
        }
      )
    }

    composable<AddPlaceScreenNavigation> {
      AddPlaceScreen(
        viewModel = addPlaceViewModel,
        onPlaceSaved = {
          navController.popBackStack()
        }
      )
    }
  }
}