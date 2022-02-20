package com.example.socialuijp.ui.theme.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialuijp.ui.theme.AppGray
import com.example.socialuijp.ui.theme.Gray_Dark
import com.example.socialuijp.ui.theme.Magenta
import com.example.socialuijp.ui.theme.utils.NavigationItem


@Composable
fun BottomNavigationBar(navController: NavController) {

    var selectedRoute by remember { mutableStateOf("Home") }

    var items = listOf(
        NavigationItem.Home,
        NavigationItem.Add,
        NavigationItem.Search,
        NavigationItem.Activities,
        NavigationItem.Profile
    )

    BottomAppBar(
        Modifier.height(56.dp),
        backgroundColor = if (isSystemInDarkTheme()) Gray_Dark else Color.White,
        contentColor = AppGray
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = it.icon), contentDescription = it.title)
                },
                selected = selectedRoute == it.route, selectedContentColor = Magenta,
                unselectedContentColor = AppGray,
                onClick = {
                    selectedRoute = it.route
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
