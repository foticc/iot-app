package com.foticc.iot.ui.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foticc.iot.components.MiddleCard
import com.foticc.iot.components.SceneSwitch
import com.foticc.iot.components.SmallShowCard
import com.foticc.iot.components.icon.FontIcon
import com.foticc.iot.components.icon.FontIcons
import com.foticc.iot.ui.dashboard.pages.ControlPage

@Preview
@Composable
fun PrevDashboard() {
    Dashboard()
}

@Composable
fun Dashboard() {
    val navController = rememberNavController()
    val context = LocalContext.current;
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable("details") {
            ControlPage(navController)
        }
    }

}


@Composable
private fun MainScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Shortcut(navController)
        Scenes(navController)
        FrequentlyUsed(navController)
    }
}


@Composable
fun Shortcut(navController: NavHostController) {
    LazyRow {
        item {
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_tv_rounded) },
                mainText = "Smart TV",
                extra = "2 Active"
            )
        }
        item {
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_lightbulb) },
                mainText = "Lights",
                extra = "2 Active"
            )
        }
        item {
            SmallShowCard(
                icon = { FontIcon(icon = FontIcons.material_symbols_air_rounded) },
                mainText = "Air Purifier",
                extra = "1 On"
            )
        }
    }
}

@Composable
fun Scenes(navController: NavHostController) {
    Column() {
        Text(text = "Scenes")
        LazyColumn {
            item {
                SceneSwitch(
                    modifier = Modifier.padding(vertical = 10.dp),
                    content = "Morning Scene"
                ) {
                    FontIcon(icon = FontIcons.ph_sun_fill)
                }
            }
            item {
                SceneSwitch(
                    content = "Night Scene"
                ) {
                    Icon(imageVector = Icons.Rounded.Face, contentDescription = "face")
                }
            }
        }
    }

}

@Composable
fun FrequentlyUsed(navController: NavHostController) {
    Column {
        Text(text = "Frequently Used", style =  MaterialTheme.typography.titleMedium)
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            // 固定两列
            columns = GridCells.Fixed(2)
        ) {
            items(5){
                MiddleCard(modifier = Modifier.clickable {
                    navController.navigate("details")
                })
            }
        }
    }

}