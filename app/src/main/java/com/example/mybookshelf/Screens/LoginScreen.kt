package com.example.mybookshelf.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.text.style.LineHeightStyle


@Composable
fun LoginScreen(gotoHome: (String) -> Unit, goToRegister: () -> Unit) {
    var userName by rememberSaveable { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
                .padding(horizontal = 8.dp, vertical = 40.dp),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = spacedBy(16.dp)
        ) {


            UserTextField(userName=userName, onTextChange={userName=it})
            LoginButton(gotoHome,userName)
            Button(
                onClick = { gotoHome("") },
                content = { Text("Login") })
        }
    }
}

@Composable
fun LoginButton(goToHome: (String)-> Unit,userName: String) {
    Button(onClick = {goToHome(userName)},
        content = {Text("Logeado")})
}



@Composable
    fun UserTextField(userName: String, onTextChange:(String)->Unit) {
        TextField(
            value = userName,
            onValueChange = {onTextChange(it)}

        )
    }