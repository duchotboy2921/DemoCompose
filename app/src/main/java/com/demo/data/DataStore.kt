package com.demo.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.demo.data.model.Product
import com.demo.nav.LoadingState
import com.demo.nav.ScreenNavigation
import com.demo.nav.StateToNavigate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.MutableStateFlow

internal var mainContext:Context? = null
internal var listProductHome:MutableStateFlow<Product> = MutableStateFlow(Product("",1.0,))
internal var currentScreen:MutableStateFlow<ScreenNavigation> = MutableStateFlow(ScreenNavigation.SplashScreen)
internal var stateToNavigate:MutableStateFlow<StateToNavigate> = MutableStateFlow(StateToNavigate.Splash)
internal var loadingState:MutableStateFlow<LoadingState> = MutableStateFlow(LoadingState.DoneLoading)
internal var firebaseAuth = FirebaseAuth.getInstance()
internal var dbProduct = FirebaseFirestore.getInstance().collection("Products")
internal var dbUser = FirebaseFirestore.getInstance().collection("Users")
internal var stIMG = FirebaseStorage.getInstance().reference.child("images").child("products_image")
internal var isFinishLoaded:MutableStateFlow<Boolean> = MutableStateFlow(false)
internal var email:MutableStateFlow<String> = MutableStateFlow("")
internal var password:MutableStateFlow<String> = MutableStateFlow("")
internal var uidCurrent:MutableStateFlow<String> = MutableStateFlow("")
internal var isDarkTheme = mutableStateOf(false)