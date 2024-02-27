package com.example.loginpage

import android.os.Bundle
import android.provider.ContactsContract.Contacts
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginpage.ui.theme.LoginpageTheme
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginpageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Nav()
                }
            }
        }
    }

}
@Composable
fun sending(){
    val database = Firebase.database
    val myRef = database.getReference("message")
    myRef.setValue("Hello, world")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(navController:NavController,modifier: Modifier = Modifier, name: String = "") {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Gray)
    ){
        var name by rememberSaveable {
            mutableStateOf("")
        }
        var university by rememberSaveable {
            mutableStateOf("")
        }
        var year by rememberSaveable {
            mutableStateOf("")
        }
        var semester by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            shape = RoundedCornerShape(30),
            label = {
                    Text(text = "Name")
            },
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Cyan, shape = RoundedCornerShape(30))
        )
        OutlinedTextField(
            value = university,
            onValueChange = {university = it},
            shape = RoundedCornerShape(30),
            label = {
                Text(text = "University Name")
            },
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Cyan, shape = RoundedCornerShape(30))
        )
        OutlinedTextField(
            value = year,
            onValueChange = {year = it},
            shape = RoundedCornerShape(30),
            label = {
                Text(text = "Year")
            },
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Cyan, shape = RoundedCornerShape(30))
        )
        OutlinedTextField(
            value = semester,
            onValueChange = {semester = it},

            label = {
                Text(text = "Semester")
            },
            shape = RoundedCornerShape(30),
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Cyan, shape = RoundedCornerShape(30))
        )
        var email by rememberSaveable {
        mutableStateOf("")
    }
        var text2 by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = email,
            onValueChange = {email = it} ,
            label = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(30),
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Cyan, shape = RoundedCornerShape(30))
        )
        OutlinedTextField(
            value = text2,
            onValueChange = {text2 = it} ,
            label = {
                Text(text = "Password")
            },
            shape = RoundedCornerShape(30),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Cyan, shape = RoundedCornerShape(30))
        )
        Button(onClick = {
            val database = Firebase.database
            val contactRef = database.reference.child("Email")
            val individualRef = contactRef.child(text2)

//            val myref = database.getReference("Name")
//            myref.setValue(name)
            val individual = listOf(name,university,year,semester,email,text2)
            individualRef.setValue(individual)
            name = ""
            university = ""
            year = ""
            semester = ""
            email = ""
            text2 = ""
        }) {
            Text(text = "Sign Up")
        }
        Button(onClick = { navController.navigate("LOGIN") }) {
            Text(text = "Log In")
        }
    }
}

@Composable
fun Contact(name: String, university: String, year: String, semester: String, text2: String):List<String> {
    val contact  = listOf<String>(name,university,year,semester,text2)
    return contact
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginpageTheme {
        Nav()
    }
}