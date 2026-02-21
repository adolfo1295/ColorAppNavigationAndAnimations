package com.ac.colorapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes : NavKey {
  @Serializable
  data object ColorListScreen : AppRoutes

  @Serializable
  data class ColorDetailsScreen(
    val colorName: String,
  ) : AppRoutes

  @Serializable
  data object FavoritesScreen : AppRoutes

  @Serializable
  data object SettingsScreen : AppRoutes
}