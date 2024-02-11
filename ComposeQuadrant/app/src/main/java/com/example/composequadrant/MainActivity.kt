package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(stringResource(id = R.string.string11),stringResource(id = R.string.string12),stringResource(id = R.string.string21),stringResource(id = R.string.string22),stringResource(id = R.string.string31),stringResource(id = R.string.string32),stringResource(id = R.string.string41),stringResource(id = R.string.string42))
                }
            }
        }
    }
}

@Composable
fun Greeting(name11: String,name12: String,name21: String, name22: String, name31: String, name32: String, name41: String, name42: String, modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row (modifier = modifier.weight(1f)){
            Column(
                modifier = modifier.fillMaxSize().weight(1f).background(Color(0xFFEADDFF)).padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(
                    text = name11,
                    modifier = modifier
                        .padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = name12,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier = modifier.fillMaxSize().weight(1f).background(Color(0xFFD0BCFF)).padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name21,
                    modifier = modifier
                        .padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = name22,
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row (modifier=modifier.weight(1f)){
            Column (
                modifier = modifier.fillMaxSize().weight(1f).background(Color(0xFFB69DF8)).padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = name31,
                    modifier = modifier
                        .padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = name32,
                    textAlign = TextAlign.Justify
                )
            }
            Column (
                modifier = modifier.fillMaxSize().weight(1f).background(Color(0xFFF6EDFF)).padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = name41,
                    modifier = modifier
                        .padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = name42,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true
    )
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting(stringResource(id = R.string.string11),stringResource(id = R.string.string12),stringResource(id = R.string.string21),stringResource(id = R.string.string22),stringResource(id = R.string.string31),stringResource(id = R.string.string32),stringResource(id = R.string.string41),stringResource(id = R.string.string42))
    }
}