package com.example.uesanapp.presentation.home

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uesanapp.presentation.components.CountryCard
import com.example.uesanapp.presentation.components.WorldCupHeader
import com.example.uesanapp.ui.theme.WorldCupGold
import com.example.uesanapp.ui.theme.WorldCupGreen
import com.example.uesanapp.ui.theme.WorldCupSurface

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val app = context.applicationContext as Application
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.factory(app))
    val countries by viewModel.countries.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        WorldCupHeader(
            title = "Ranking FIFA",
            subtitle = "Toca la estrella para añadir a tus favoritos"
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(containerColor = WorldCupSurface),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Icon(
                    imageVector = Icons.Filled.EmojiEvents,
                    contentDescription = null,
                    tint = WorldCupGold,
                    modifier = Modifier.size(26.dp)
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Copa Mundial de la FIFA 2026",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    ),
                    color = WorldCupGreen
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "Estados Unidos · Canadá · México",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(countries, key = { it.name }) { country ->
                CountryCard(
                    country = country,
                    onToggleFavorite = { viewModel.toggleFavorite(country) }
                )
            }
        }
    }
}
