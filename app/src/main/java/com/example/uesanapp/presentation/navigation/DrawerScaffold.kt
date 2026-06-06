package com.example.uesanapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uesanapp.ui.theme.WorldCupGold
import com.example.uesanapp.ui.theme.WorldCupGreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(
    navController: NavController,
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .padding(0.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Icon(
                            imageVector = Icons.Filled.EmojiEvents,
                            contentDescription = null,
                            tint = WorldCupGold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "MUNDIAL 2026",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 2.sp
                        ),
                        color = WorldCupGreen
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Menú principal",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    NavigationDrawerItem(
                        label = { Text("Home") },
                        selected = false,
                        icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = WorldCupGreen.copy(alpha = 0.15f),
                            selectedIconColor = WorldCupGreen,
                            selectedTextColor = WorldCupGreen
                        ),
                        onClick = {
                            navController.navigate("home")
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Permissions") },
                        selected = false,
                        icon = { Icon(Icons.Filled.PhotoLibrary, contentDescription = null) },
                        onClick = {
                            navController.navigate("permissions")
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Favoritos") },
                        selected = false,
                        icon = { Icon(Icons.Filled.Star, contentDescription = null, tint = WorldCupGold) },
                        onClick = {
                            navController.navigate("favorites")
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("UESAN App") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            {
                content()
            }
        }

    }
}
