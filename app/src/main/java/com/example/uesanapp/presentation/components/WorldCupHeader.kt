package com.example.uesanapp.presentation.components

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uesanapp.ui.theme.WorldCupGold
import com.example.uesanapp.ui.theme.WorldCupHeaderGradient

@Composable
fun WorldCupHeader(
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(WorldCupHeaderGradient)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(WorldCupGold),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.EmojiEvents,
                    contentDescription = null,
                    tint = Color(0xFF1B1B1B),
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "MUNDIAL 2026",
                    color = WorldCupGold,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )
                )
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(
                    text = subtitle,
                    color = Color(0xFFE5E5E5),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Filled.SportsSoccer,
                contentDescription = null,
                tint = WorldCupGold.copy(alpha = 0.9f),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
