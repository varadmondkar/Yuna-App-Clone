package com.varad.yunaappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.varad.yunaappclone.core.navigation.Route
import com.varad.yunaappclone.ui.home.HomeScreen
import com.varad.yunaappclone.ui.summary.SummaryScreen
import com.varad.yunaappclone.ui.theme.YunaAppCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YunaAppCloneTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = Route.HOME,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Route.HOME) {
                            HomeScreen {
                                navController.navigate(it.route)
                            }
                        }
                        composable(Route.SUMMARY) {
                            SummaryScreen {

                            }
                        }
                    }
                }
            }
        }
    }
}