package com.example.uesanapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.uesanapp.data.local.CountryEntity
import com.example.uesanapp.ui.theme.WorldCupGold
import com.example.uesanapp.ui.theme.WorldCupGoldDark
import com.example.uesanapp.ui.theme.WorldCupGreen
import com.example.uesanapp.ui.theme.WorldCupRed

@Composable
fun CountryCard(
    country: CountryEntity,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(WorldCupGold, WorldCupGoldDark)
                        )
                    )
                    .padding(2.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(country.imageUrl),
                    contentDescription = country.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = country.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(22.dp)
                            .clip(CircleShape)
                            .background(WorldCupGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = country.ranking.toString(),
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Ranking FIFA",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }

            IconButton(
                onClick = onToggleFavorite,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        if (country.isFavorite) WorldCupGold.copy(alpha = 0.18f)
                        else Color.Transparent
                    )
            ) {
                AnimatedVisibility(
                    visible = country.isFavorite,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Quitar de favoritos",
                        tint = WorldCupGold
                    )
                }
                if (!country.isFavorite) {
                    Icon(
                        imageVector = Icons.Filled.StarBorder,
                        contentDescription = "Marcar como favorito",
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}
