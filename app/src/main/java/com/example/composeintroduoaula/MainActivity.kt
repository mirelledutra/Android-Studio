package com.example.composeintroduoaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeintroduoaula.ui.InicioScreen
import com.example.composeintroduoaula.ui.LoginScreen
import com.example.composeintroduoaula.ui.MinhaContaScreen
import com.example.composeintroduoaula.ui.theme.ComposeIntroduçãoAulaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeIntroduçãoAulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "minhaConta"
                    ) {
                        composable("inicio") {
                            InicioScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("minhaConta") {
                            MinhaContaScreen(navController)
                        }

                    }
                }
            }
        }
    }
}