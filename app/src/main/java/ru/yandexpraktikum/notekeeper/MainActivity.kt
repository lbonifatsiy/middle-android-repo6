package ru.yandexpraktikum.notekeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import ru.yandexpraktikum.notekeeper.presentation.navigation.NoteKeeperNavHost
import ru.yandexpraktikum.core_ui.presentation.theme.NoteKeeperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteKeeperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val container = (LocalContext.current.applicationContext as NoteKeeperApp).container
                    NoteKeeperNavHost(
                        appContainer = container,
                        navController = navController
                    )
                }
            }
        }
    }
}