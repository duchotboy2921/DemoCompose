package com.demo.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.data.*
import com.demo.nav.ScreenNavigation

class LoginViewModel:ViewModel() {
    fun verifyLogin(){
        firebaseAuth.signInWithEmailAndPassword(email.value, password.value)
            .addOnSuccessListener {
                currentScreen.value = ScreenNavigation.HomeScreen
                uidCurrent.value = firebaseAuth.uid.toString()
            }
            .addOnFailureListener {
                currentScreen.value = ScreenNavigation.LoginScreen
            }
    }
    fun checkIfAlreadyLogin(){
        if (uidCurrent.value!=""){
            currentScreen.value = ScreenNavigation.HomeScreen
        }
    }
}