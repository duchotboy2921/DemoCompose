package com.demo.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.data.currentScreen
import com.demo.data.firebaseAuth
import com.demo.data.stateToNavigate
import com.demo.data.uidCurrent
import com.demo.nav.ScreenNavigation
import com.demo.nav.StateToNavigate

class MenuViewModel:ViewModel() {
    fun signOut(){
        firebaseAuth.signOut()
        uidCurrent.value = ""
        currentScreen.value = ScreenNavigation.LoginScreen
        stateToNavigate.value = StateToNavigate.SignOut
    }
    fun onBackPressed(){
        currentScreen.value = ScreenNavigation.HomeScreen
        stateToNavigate.value = StateToNavigate.SignOut
    }
}