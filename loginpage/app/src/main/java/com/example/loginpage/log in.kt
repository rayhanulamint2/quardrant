package com.example.loginpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.database.database

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun logIn(navController: NavController, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text1 by rememberSaveable {
            mutableStateOf("")
        }
        var text2 by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = text1,
            onValueChange = {text1 = it} ,
            label = {
                Text(text = "Email")
            }
        )
        OutlinedTextField(
            value = text2,
            onValueChange = {text2 = it} ,
            label = {
                Text(text = "Password")
            }
        )
        Button(onClick = {
            val database = Firebase.database
            val myref1 = database.getReference("Email")
            myref1.setValue(text1)
            val myref2 = database.getReference("Password")
            myref2.setValue(text2)

        }) {
            Text(text = "Log In")
        }
        Button(onClick = { navController.navigate("SIGNUP")}) {
            Text(text = "Sign Up")
        }
    }
}