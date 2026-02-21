package com.ac.colorapp.navigation.advanced

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ac.colorapp.navigation.AppRoutes
import com.ac.colorapp.screens.ColorDetailsScreen
import com.ac.colorapp.screens.ColorListScreen
import com.ac.colorapp.screens.colorList

enum class MainTabs(
  val title: String,
  val selectedIcon: ImageVector,
  val unSelectedIcon: ImageVector,
) {
  COLORS(
    title = "Colors",
    selectedIcon = Icons.Filled.Home,
    unSelectedIcon = Icons.Outlined.Home
  ),
  FAVORITES(
    title = "Favorites",
    selectedIcon = Icons.Filled.Favorite,
    unSelectedIcon = Icons.Outlined.FavoriteBorder
  ),
  SETTINGS(
    title = "Settings",
    selectedIcon = Icons.Filled.Settings,
    unSelectedIcon = Icons.Outlined.Settings
  )
}

@Composable
fun AdvancedNavigation() {

  var currentTab by remember { mutableStateOf(MainTabs.COLORS) }

  val colorsBackStack = rememberNavBackStack(AppRoutes.ColorListScreen)
  val favoritesBackStack = rememberNavBackStack(AppRoutes.FavoritesScreen)
  val settingsBackStack = rememberNavBackStack(AppRoutes.SettingsScreen)

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = {
      NavigationBar {
        MainTabs.entries.forEach { tab ->
          NavigationBarItem(
            selected = tab == currentTab,
            onClick = {
              currentTab = tab
            },
            label = {
              Text(tab.title)
            },
            icon = {
              Icon(
                imageVector = if (tab == currentTab) tab.selectedIcon else tab.unSelectedIcon,
                contentDescription = tab.title
              )
            }
          )
        }
      }
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      when (currentTab) {
        MainTabs.COLORS -> {
          NavDisplay(
            backStack = colorsBackStack,
            onBack = {
              colorsBackStack.removeLastOrNull()
            },
            transitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { -it }
              )
            },
            popTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            predictivePopTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            entryProvider = entryProvider {
              entry<AppRoutes.ColorListScreen> {
                ColorListScreen(
                  colorList = colorList,
                  onColorClick = { colorName ->
                    colorsBackStack.add(AppRoutes.ColorDetailsScreen(
                      colorName = colorName
                    ))
                  }
                )
              }
              entry<AppRoutes.ColorDetailsScreen> { key ->
                ColorDetailsScreen(
                  colorName = key.colorName,
                  navigateUp = {
                    colorsBackStack.removeLastOrNull()
                  }
                )
              }
            }
          )
        }

        MainTabs.FAVORITES -> {
          NavDisplay(
            backStack = favoritesBackStack,
            onBack = {
              favoritesBackStack.removeLastOrNull()
            },
            transitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { -it }
              )
            },
            popTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            predictivePopTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            entryProvider = entryProvider {
              entry<AppRoutes.FavoritesScreen> {
                val mockList = colorList.take(3)
                ColorListScreen(
                  colorList = mockList,
                  onColorClick = { colorName ->
                    favoritesBackStack.add(AppRoutes.ColorDetailsScreen(
                      colorName = colorName
                    ))
                  }
                )
              }
              entry<AppRoutes.ColorDetailsScreen> { key ->
                ColorDetailsScreen(
                  colorName = key.colorName,
                  navigateUp = {
                    favoritesBackStack.removeLastOrNull()
                  }
                )
              }
            }
          )
        }

        MainTabs.SETTINGS -> {
          NavDisplay(
            backStack = settingsBackStack,
            onBack = {
              settingsBackStack.removeLastOrNull()
            },
            transitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { -it }
              )
            },
            popTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            predictivePopTransitionSpec = {
              slideInHorizontally(
                animationSpec = tween(2000),
                initialOffsetX = { -it }
              ) togetherWith slideOutHorizontally(
                animationSpec = tween(2000),
                targetOffsetX = { it }
              )
            },
            entryProvider = entryProvider {
              entry<AppRoutes.SettingsScreen> { }
            }
          )
        }
      }
    }
  }

}