package com.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.demo.data.*
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
    displayLoading()
}

@Composable
fun displayLoading() {
    val isLoading = loadingState.collectAsState().value
    if(isLoading == LoadingState.Loading){
        Column(modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(id = R.drawable.shopee_icon_loading),
                contentDescription = "icon_loading")
        }
    }
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