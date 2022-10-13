package com.demo.data

import com.demo.data.model.Product
import com.demo.nav.ScreenNavigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.MutableStateFlow

internal var listProductHome:MutableStateFlow<Product> = MutableStateFlow(Product("",1.0,))
internal var currentScreen:MutableStateFlow<ScreenNavigation> = MutableStateFlow(ScreenNavigation.LoginScreen)
internal var firebaseAuth = FirebaseAuth.getInstance()
internal var dbProduct = FirebaseFirestore.getInstance().collection("Products")
internal var dbUser = FirebaseFirestore.getInstance().collection("Users")
internal var stIMG = FirebaseStorage.getInstance().reference.child("images").child("products_image")
internal var isFinishLoaded:MutableStateFlow<Boolean> = MutableStateFlow(false)
internal var email:MutableStateFlow<String> = MutableStateFlow("")
internal var password:MutableStateFlow<String> = MutableStateFlow("")
internal var uidCurrent:MutableStateFlow<String> = MutableStateFlow("")