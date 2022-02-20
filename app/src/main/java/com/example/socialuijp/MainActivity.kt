package com.example.socialuijp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.socialuijp.ui.theme.SocialUiJPTheme
import com.example.socialuijp.ui.theme.component.BottomNavigationBar
import com.example.socialuijp.ui.theme.screen.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialUiJPTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    mainUi()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun mainUi() {
    var navController = rememberNavController()
    var fullScreen by remember { mutableStateOf(false)}
    Scaffold(
        topBar = { if(!fullScreen) com.example.socialuijp.ui.theme.component.TopAppBar() },
        bottomBar = { if(!fullScreen) BottomNavigationBar(navController) }
    ) {
        NavHost(navController = navController, startDestination = "Home") {
            composable("Home") {
                fullScreen = false
                Home(navController)
            }
            composable("Search") {
                fullScreen = false
                Search()
            }
            composable("Add") {
                fullScreen = false
                Add()
            }
            composable("Activities") {
                fullScreen = false
                Activities()
            }
            composable("Profile") {
                fullScreen = false
                Profile()
            }
            composable(
                "ShowStoryScreen/{index}", arguments = listOf(navArgument("index") {
                    type = NavType.IntType
                })
            ) { backStack ->
                fullScreen = true
                ShowStoryScreen(backStack.arguments?.get("index") as Int)
            }
        }
    }
}
