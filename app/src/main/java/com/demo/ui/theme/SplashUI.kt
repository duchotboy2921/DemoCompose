package com.demo.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.R
import com.demo.data.firebaseAuth
import com.demo.viewmodel.SplashViewModel

@Composable
fun SplashUI(splashViewModel: SplashViewModel){
    val isEnable = remember { mutableStateOf(false) }
    val shopeeOffSet by animateOffsetAsState(
        targetValue = if(isEnable.value)Offset(140f,250f) else Offset(150f,800f),
        animationSpec = tween(3000),
        finishedListener = {
            if(firebaseAuth.currentUser == null){
                splashViewModel.navigateToLoginScreen()
            }else{
                splashViewModel.navigateToHomeScreen()
            }
        }
    )
    LaunchedEffect(true){
        isEnable.value = !isEnable.value
    }
    Image(
        painter = painterResource(id = R.drawable.splashicon),
        contentDescription = "splash_Icon",
        modifier = Modifier
            .offset(shopeeOffSet.x.dp, shopeeOffSet.y.dp)
            .size(130.dp))
    BackHandler {

    }
}
