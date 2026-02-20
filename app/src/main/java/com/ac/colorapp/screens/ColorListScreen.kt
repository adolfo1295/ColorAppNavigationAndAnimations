package com.ac.colorapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ac.colorapp.modals.ColorItem
import com.ac.colorapp.ui.theme.CoralVibe
import com.ac.colorapp.ui.theme.DeepTeal
import com.ac.colorapp.ui.theme.ElectricViolet
import com.ac.colorapp.ui.theme.SoftLavender
import com.ac.colorapp.ui.theme.SoftMint
import com.ac.colorapp.ui.theme.SoftRose
import com.ac.colorapp.ui.theme.SoftSky
import com.ac.colorapp.ui.theme.SunshineYellow

val colorList = listOf(
  ColorItem(name = "SoftMint", color = SoftMint),
  ColorItem(name = "SoftSky", color = SoftSky),
  ColorItem(name = "SoftLavender", color = SoftLavender),
  ColorItem(name = "SoftRose", color = SoftRose),
  ColorItem(name = "ElectricViolet", color = ElectricViolet),
  ColorItem(name = "CoralVibe", color = CoralVibe),
  ColorItem(name = "SunshineYellow", color = SunshineYellow),
  ColorItem(name = "DeepTeal", color = DeepTeal),
)

@Composable
fun ColorListScreen(
  onColorClick: (String) -> Unit,
) {

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
      .navigationBarsPadding(),
    contentPadding = PaddingValues(horizontal = 8.dp)
  ) {
    items(colorList) { colorItem ->
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .height(120.dp)
          .padding(vertical = 8.dp),
        onClick = {
          onColorClick(colorItem.name)
        }
      ) {
        Row(
          modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Start
        ) {
          Box(
            modifier = Modifier.padding(horizontal = 12.dp)
              .size(60.dp)
              .clip(CircleShape)
              .background(colorItem.color)
          )
          Text(
            text = colorItem.name
          )
        }
      }
    }
  }
}

@Preview
@Composable
fun ColorListPreview(modifier: Modifier = Modifier) {
  ColorListScreen { }
}