package com.demo.nav

import androidx.navigation.NavHostController

lateinit var rootNav: NavHostController
fun pushScreen(screen : ScreenNavigation){
    rootNav.navigate(screen.rout){
        launchSingleTop = true
    }
}
fun popAndPushScreen(screen: ScreenNavigation){
    rootNav.popBackStack()
    rootNav.navigate(screen.rout){
        launchSingleTop = true
    }
}