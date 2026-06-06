package com.example.uesanapp.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.uesanapp.data.local.CountryEntity
import com.example.uesanapp.data.local.CountryRepository
import com.example.uesanapp.data.local.DatabaseProvider
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application,
    private val repository: CountryRepository
) : AndroidViewModel(application) {

    val countries: StateFlow<List<CountryEntity>> = repository.observeAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun toggleFavorite(country: CountryEntity) {
        viewModelScope.launch {
            repository.toggleFavorite(country.name, country.isFavorite)
        }
    }

    companion object {
        fun factory(application: Application): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(
                        application,
                        DatabaseProvider.repository(application)
                    ) as T
                }
            }
        }
    }
}
