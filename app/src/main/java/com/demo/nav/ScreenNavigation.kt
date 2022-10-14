package com.demo.nav

sealed class ScreenNavigation(var rout:String) {
    object SplashScreen:ScreenNavigation("splash_screen")
    object LoginScreen:ScreenNavigation("login_screen")
    object HomeScreen:ScreenNavigation("home_screen")
    object MenuScreen:ScreenNavigation("menu_screen")
}
sealed class StateToNavigate(){
    object Login:StateToNavigate()
    object SignOut:StateToNavigate()
    object HomeToOther:StateToNavigate()
    object Splash:StateToNavigate()
}