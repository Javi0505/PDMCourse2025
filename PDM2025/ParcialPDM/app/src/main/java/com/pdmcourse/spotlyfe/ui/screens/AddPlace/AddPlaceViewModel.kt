package com.pdmcourse.spotlyfe.ui.screens.AddPlace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.SpotLyfeApplication
import com.pdmcourse.spotlyfe.data.repository.PlaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer


class AddPlaceViewModel(
    private val placeRepository: PlaceRepository
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _description = MutableStateFlow("")
    val description: StateFlow<String> = _description.asStateFlow()

    private val _location = MutableStateFlow<LatLng?>(null)
    val location: StateFlow<LatLng?> = _location.asStateFlow()

    val canSave: StateFlow<Boolean> = combine(_name, _location) { name, loc ->
        name.isNotBlank() && loc != null
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    fun onNameChange(new: String) {
        _name.value = new
    }

    fun onDescriptionChange(new: String) {
        _description.value = new
    }

    fun onLocationSelected(latLng: LatLng) {
        _location.value = latLng
    }

    /** Persiste el Place en Room */
    fun savePlace() = viewModelScope.launch {
        val loc = _location.value ?: return@launch
        placeRepository.savePlace(
            Place(
                id = 0,
                name      = _name.value,
                remark    = _description.value.ifBlank { "" },
                latitude  = loc.latitude,
                longitude = loc.longitude
            )
        )
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SpotLyfeApplication
                AddPlaceViewModel(app.appProvider.providePlaceRepository())
            }
        }
    }
}