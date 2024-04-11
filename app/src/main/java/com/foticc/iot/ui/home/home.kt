package com.foticc.iot.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.foticc.iot.ui.theme.Maybeblack
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(modifier = Modifier.height(50.dp), navController = navController)
        }
    ) {
        Content(modifier = Modifier.padding(it), navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "My Home") }, actions = {
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Add, contentDescription = "add")
        }
    })
}


@Composable
fun Content(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomItem.Dashboard.route
    ) {
        composable(BottomItem.Dashboard.route) {
            Text(text = "123")
        }
        composable(BottomItem.Rooms.route) {
            Text(text = "456")
        }
        composable(BottomItem.Profiles.route) {
            Text(text = "789")
        }
    }
}


@Composable
fun BottomBar(modifier: Modifier = Modifier, navController: NavHostController) {
    val items = listOf(
        BottomItem.Dashboard,
        BottomItem.Rooms,
        BottomItem.Profiles,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(modifier = modifier.clip(RoundedCornerShape(16)), contentColor = Maybeblack) {
        items.forEachIndexed { index, bottomItem ->
            NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == bottomItem.route } == true,
                onClick = {
                    navController.navigate(bottomItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    IconLabelAuto(icon = bottomItem,
                        selected = currentDestination?.hierarchy?.any { it.route == bottomItem.route } == true)
                })
        }
    }

}

@Composable
fun IconLabelAuto(
    modifier: Modifier = Modifier,
    icon: BottomItem,
    selected: Boolean,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon.icon, contentDescription = icon.title)
        if (selected) {
            Text(modifier = Modifier.padding(start = 1.dp), text = icon.title)
        }
    }
}


@Preview
@Composable
fun Preview() {
    val navController = rememberNavController()
    Home(navController = navController)
}