package com.demo.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.ui.theme.HomeUI
import com.demo.ui.theme.LoginUI
import com.demo.ui.theme.MenuUI
import com.demo.ui.theme.SplashUI
import com.demo.viewmodel.HomeViewmodel
import com.demo.viewmodel.LoginViewModel
import com.demo.viewmodel.MenuViewModel
import com.demo.viewmodel.SplashViewModel

@Composable
fun setupGraph(navHostController: NavHostController){
    NavHost(navController = navHostController,
        startDestination = ScreenNavigation.SplashScreen.rout ){
        composable (ScreenNavigation.SplashScreen.rout){
            SplashUI(SplashViewModel())
        }
        composable(ScreenNavigation.HomeScreen.rout){
            HomeUI(HomeViewmodel())
        }
        composable(ScreenNavigation.LoginScreen.rout){
            LoginUI(LoginViewModel())
        }
        composable(ScreenNavigation.MenuScreen.rout){
            MenuUI(MenuViewModel())
        }
    }
}