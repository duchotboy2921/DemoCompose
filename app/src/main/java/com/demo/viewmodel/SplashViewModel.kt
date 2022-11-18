package com.demo.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.data.currentScreen
import com.demo.data.stateToNavigate
import com.demo.nav.ScreenNavigation
import com.demo.nav.StateToNavigate

class SplashViewModel:ViewModel() {
    fun navigateToLoginScreen(){
        currentScreen.value = ScreenNavigation.LoginScreen
        stateToNavigate.value = StateToNavigate.Splash
    }
    fun navigateToHomeScreen(){
        currentScreen.value = ScreenNavigation.HomeScreen
        stateToNavigate.value = StateToNavigate.Splash
    }

}