package com.demo.nav

sealed class ScreenNavigation(var rout:String) {
    object SplashScreen:ScreenNavigation("splash_screen")
    object LoginScreen:ScreenNavigation("login_screen")
    object HomeScreen:ScreenNavigation("home_screen")
}