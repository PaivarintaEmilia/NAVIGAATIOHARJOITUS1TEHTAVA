package com.example.navigaatioharjoitus1tehtava

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
import com.example.navigaatioharjoitus1tehtava.ui.theme.NAVIGAATIOHARJOITUS1TEHTAVATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Controlleri navHostia varten
            val navController = rememberNavController()

            NAVIGAATIOHARJOITUS1TEHTAVATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // navHostin luominen
                    NavHost(navController = navController, startDestination =  "screenA") {
                        // Jokaiselle screenille tehdään composable tähän
                        composable("screenA") {
                            ScreenA(goToScreenB = {
                                navController.navigate("screenB")
                            }, goToScreenC = {
                                navController.navigate("screenB")
                            })
                        }
                        composable("screenB") {
                            ScreenB(goToScreenA = {
                                navController.navigate("screenA")
                            })
                        }
                        composable("screenC") {
                            ScreenC(goToScreenA = {
                               navController.navigate("screenA")
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NAVIGAATIOHARJOITUS1TEHTAVATheme {
        Greeting("Android")
    }
}