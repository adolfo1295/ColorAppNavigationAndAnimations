package com.ac.colorapp.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ac.colorapp.screens.ColorDetailsScreen
import com.ac.colorapp.screens.ColorListScreen

@Composable
fun BasicNavigation() {

  val backStack = rememberNavBackStack(AppRoutes.ColorListScreen)

  NavDisplay(
    backStack = backStack,
    onBack = {
      backStack.removeLastOrNull()
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
          onColorClick = { colorName ->
            backStack.add(AppRoutes.ColorDetailsScreen(
              colorName = colorName
            ))
          }
        )
      }
      entry<AppRoutes.ColorDetailsScreen> { key ->
        ColorDetailsScreen(
          colorName = key.colorName,
          navigateUp = {
            backStack.removeLastOrNull()
          }
        )
      }
    }
  )

}