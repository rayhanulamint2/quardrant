package com.example.quardrant

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
import com.example.quardrant.ui.theme.QuardrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuardrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            parts(
                stringResource(id = R.string.one_title),
                stringResource(id = R.string.one_para),
                Modifier.background(
                    Color(0xFFEADDFF)
                ).weight(1f)
            )
            parts(
                stringResource(id = R.string.two_title),
                stringResource(id = R.string.two_para),
                Modifier.background(
                    Color(0xFFD0BCFF)
                ).weight(1f)
            )
        }
        Row(
            Modifier.weight(1f)
        ) {
            parts(
                stringResource(id = R.string.three_title),
                stringResource(id = R.string.three_para),
                Modifier.background(
                    Color(0xFFB69DF8)
                ).weight(1f)
            )
            parts(
                stringResource(id = R.string.four_title),
                stringResource(id = R.string.four_para),
                Modifier.background(
                    Color(0xFFF6EDFF)
                ).weight(1f)
            )
        }
    }
}

@Composable
fun parts(title: String,para:String,modifier:Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp).fillMaxSize()
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = para,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    QuardrantTheme {
        Greeting()
    }
}