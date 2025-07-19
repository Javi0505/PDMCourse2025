package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.data.repository.PlaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SavedPlacesViewModel(
    private val repository: PlaceRepository
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places = _places.asStateFlow()


    private val _selectedLocation = mutableStateOf<Pair<Double, Double>?>(null)
    val selectedLocation: State<Pair<Double, Double>?> = _selectedLocation

    fun setSelectedLocation(latitude: Double, longitude: Double) {
        _selectedLocation.value = latitude to longitude
    }

    fun savePlace(name: String, remark: String) {
        val location = _selectedLocation.value ?: return
        val (lat, lng) = location

        val place = Place(
            name = name,
            remark = remark,
            latitude = lat,
            longitude = lng
        )

        viewModelScope.launch {
            repository.savePlace(place)
        }
    }

    fun loadPlaces() {
        viewModelScope.launch {
            repository.getPlaces().collectLatest {
                _places.value = it
            }
        }
    }
}
