package com.foticc.iot.ui.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
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
import com.foticc.iot.ui.dashboard.Dashboard
import com.foticc.iot.ui.dashboard.PrevDashboard
import com.foticc.iot.ui.profiles.Profiles
import com.foticc.iot.ui.rooms.RoomsPages
import com.foticc.iot.ui.theme.Maybeblack
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController) {

    val scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    Scaffold(
        topBar = {
            TopBar(onClick = {
                scope.launch {
                    isBottomSheetVisible = true
                    sheetState.expand()
                }
            })
        },
        bottomBar = {
            BottomBar(modifier = Modifier.height(50.dp), navController = navController)
        }
    ) {
        Content(modifier = Modifier.padding(it), navController = navController)
    }


    BottomSheet(
        isBottomSheetVisible = isBottomSheetVisible,
        sheetState = sheetState,
        onDismiss = {
            scope.launch { sheetState.hide() }
                .invokeOnCompletion { isBottomSheetVisible = false }
        }
    ){
        Text(text = "123123123123")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val context = LocalContext.current
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary
    ), title = { Text(text = "My Home") }, actions = {
        IconButton(onClick = onClick) {
            Icon(Icons.Filled.Add, contentDescription = "add")
        }
    })
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(isBottomSheetVisible: Boolean,
                sheetState: SheetState,
                onDismiss: () -> Unit,
                content: @Composable ColumnScope.() -> Unit) {
    if (isBottomSheetVisible) {

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
//            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
//            dragHandle = null,
//            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0),
            content = content
        )
    }
}


@Composable
fun Content(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomItem.Dashboard.route
    ) {
        composable(BottomItem.Dashboard.route) {
            Dashboard()
        }
        composable(BottomItem.Rooms.route) {
            RoomsPages()
        }
        composable(BottomItem.Profiles.route) {
            Profiles()
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
    NavigationBar(
        modifier = modifier.clip(
            RoundedCornerShape(
                topStart = 16f,
                topEnd = 16f
            )
        ),
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
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
        Icon(tint = Color.White, imageVector = icon.icon, contentDescription = icon.title)
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