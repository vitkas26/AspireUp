package kg.life.aspireUp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kg.life.aspireUp.ui.AspireTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            val keepSplashScreen = remember { mutableStateOf(true) }

            // Keep splash screen on while content is loading
            LaunchedEffect(key1 = Unit) {
                // Simulate content loading
                delay(2000) // Replace with your actual loading logic
                keepSplashScreen.value = false
            }

            splashScreen.setKeepOnScreenCondition {
                keepSplashScreen.value
            }

            if (!keepSplashScreen.value) {
                AspireTheme {
                    Column(modifier = Modifier.fillMaxSize()) { Text("Hello App") }
                }
            }
        }
    }
}