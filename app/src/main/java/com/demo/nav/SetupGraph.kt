package com.demo.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.ui.theme.HomeUI
import com.demo.ui.theme.LoginUI
import com.demo.ui.theme.SplashUI
import com.demo.viewmodel.HomeViewmodel
import com.demo.viewmodel.LoginViewModel

@Composable
fun setupGraph(navHostController: NavHostController){
    NavHost(navController = navHostController,
        startDestination = ScreenNavigation.LoginScreen.rout ){
        composable (ScreenNavigation.SplashScreen.rout){
            SplashUI()
        }
        composable(ScreenNavigation.HomeScreen.rout){
            HomeUI(HomeViewmodel())
        }
        composable(ScreenNavigation.LoginScreen.rout){
            LoginUI(LoginViewModel())
        }
    }
}