package com.aniruddha81.hiltretrofitnavigationmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aniruddha81.hiltretrofitnavigationmvvm.screens.CategoryScreen
import com.aniruddha81.hiltretrofitnavigationmvvm.screens.DetailsScreen
import com.aniruddha81.hiltretrofitnavigationmvvm.ui.theme.HiltretrofitnavigationmvvmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HiltretrofitnavigationmvvmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { p ->
                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("details/$it")
            }
        }
        composable(route = "details/{category}", arguments = listOf(navArgument("category") {
            type =
                NavType.StringType
        })) {
            DetailsScreen()
        }
    }
}