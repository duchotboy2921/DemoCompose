package com.demo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.R
import com.demo.data.email
import com.demo.data.password
import com.demo.viewmodel.LoginViewModel

@Composable
fun LoginUI(loginViewModel: LoginViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.shopee_login),
            contentDescription = "icon_login")
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
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation())
         OutlinedButton(onClick = {loginViewModel.verifyLogin()}) {
             Text(text = "Login")
         }
    }

}
