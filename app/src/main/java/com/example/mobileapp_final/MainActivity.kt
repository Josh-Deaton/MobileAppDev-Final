package com.example.mobileapp_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobileapp_final.ui.theme.CourseConnectTheme
import com.example.mobileapp_final.screens.CourseListScreen
import com.example.mobileapp_final.screens.ChatScreen
import com.example.mobileapp_final.screens.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseConnectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseConnectApp()
                }
            }
        }
    }
}

@Composable
fun CourseConnectApp() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "courses") {
        composable("courses") {
            CourseListScreen(navController)
        }
        composable("chat/{courseId}") { backStackEntry ->
            ChatScreen(
                courseId = backStackEntry.arguments?.getString("courseId") ?: "",
                navController = navController
            )
        }
        composable("profile") {
            ProfileScreen(navController)
        }
    }
}
