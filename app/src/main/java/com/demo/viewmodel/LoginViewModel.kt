package com.demo.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.demo.R
import com.demo.data.*
import com.demo.nav.ScreenNavigation
import com.demo.nav.StateToNavigate

class LoginViewModel:ViewModel() {
    fun verifyLogin(){
        firebaseAuth.signInWithEmailAndPassword(email.value, password.value)
            .addOnSuccessListener {
                currentScreen.value = ScreenNavigation.HomeScreen
                stateToNavigate.value = StateToNavigate.Login
            }
            .addOnFailureListener {
                currentScreen.value = ScreenNavigation.LoginScreen
                Toast.makeText(mainContext, R.string.error_login,Toast.LENGTH_LONG).show()
            }
    }
}