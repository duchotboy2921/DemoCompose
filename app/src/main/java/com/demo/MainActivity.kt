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
import com.demo.data.isDarkTheme
import com.demo.data.mainContext
import com.demo.data.stateToNavigate
import com.demo.nav.*
import com.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme(isDarkTheme.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loadView()
                }
            }
        }
        mainContext = this
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
    val state = stateToNavigate.collectAsState().value
    if(state == StateToNavigate.HomeToOther){
        pushScreen(screen)
    }else{
        popAndPushScreen(screen)
    }

}