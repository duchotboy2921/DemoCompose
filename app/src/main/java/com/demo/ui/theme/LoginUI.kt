package com.demo.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.data.email
import com.demo.data.password
import com.demo.viewmodel.LoginViewModel

@Composable
fun LoginUI(loginViewModel: LoginViewModel){
    loginViewModel.checkIfAlreadyLogin()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
         Text(
             text = "Login",
             fontSize = 20.sp,
             fontWeight = FontWeight.ExtraBold)
         OutlinedTextField(
             value = email.collectAsState().value ,
             onValueChange ={ email.value = it},
             label = { Text(text = "Email")})
        OutlinedTextField(
            value = password.collectAsState().value ,
            onValueChange ={ password.value = it},
            label = { Text(text = "Password")})
         OutlinedButton(onClick = {loginViewModel.verifyLogin()}) {
             Text(text = "Login")
         }
    }

}