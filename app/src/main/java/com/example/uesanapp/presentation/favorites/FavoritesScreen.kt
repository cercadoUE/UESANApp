package com.example.uesanapp.presentation.favorites

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uesanapp.presentation.components.CountryCard
import com.example.uesanapp.presentation.components.WorldCupHeader
import com.example.uesanapp.ui.theme.WorldCupGold
import com.example.uesanapp.ui.theme.WorldCupGoldDark
import com.example.uesanapp.ui.theme.WorldCupGreen
import com.example.uesanapp.ui.theme.WorldCupSurface

@Composable
fun FavoritesScreen() {
    val context = LocalContext.current
    val app = context.applicationContext as Application
    val viewModel: FavoritesViewModel = viewModel(factory = FavoritesViewModel.factory(app))
    val favorites by viewModel.favorites.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        WorldCupHeader(
            title = "Mis favoritos",
            subtitle = "Tus selecciones del Mundial 2026"
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(containerColor = WorldCupSurface),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(WorldCupGold),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.EmojiEvents,
                        contentDescription = null,
                        tint = Color(0xFF1B1B1B)
                    )
                }
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Tus estrellas del Mundial",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Black
                        ),
                        color = WorldCupGreen
                    )
                    Text(
                        text = "${favorites.size} selección${if (favorites.size == 1) "" else "es"} guardada${if (favorites.size == 1) "" else "s"}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
        }

        if (favorites.isEmpty()) {
            EmptyFavorites()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(favorites, key = { it.name }) { country ->
                    CountryCard(
                        country = country,
                        onToggleFavorite = { viewModel.toggleFavorite(country) }
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyFavorites() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(WorldCupGold, WorldCupGoldDark)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.StarBorder,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Aún no tienes favoritos",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Black
                ),
                color = WorldCupGreen
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Vuelve al Ranking FIFA y toca la estrella de las selecciones que quieras seguir en el Mundial 2026.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        }
    }
}
