package com.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.demo.data.currentScreen
import com.demo.nav.popAndPushScreen
import com.demo.nav.rootNav
import com.demo.nav.setupGraph
import com.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loadView()
                }
            }
        }
    }
}

@Composable
fun loadView(){
    rootNav = rememberNavController()
    setupGraph(navHostController = rootNav)
    changeScreenByState()
}
@Composable
fun changeScreenByState(){
    val screen = currentScreen.collectAsState().value
    popAndPushScreen(screen)
}