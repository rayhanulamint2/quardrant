package com.example.business

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business.ui.theme.BusinessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessTheme {
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
fun Greeting(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.win_20230913_18_51_52_pro)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = image, contentDescription = null,
                modifier = modifier.height(100.dp)
            )
            Text(
                text = stringResource(id = R.string.name),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.title)
            )
        }
        Column(

        ) {
            val img2 = painterResource(id = R.drawable.public_fill0_wght400_grad0_opsz24)
            val img1 = painterResource(id = R.drawable.phone_iphone_fill0_wght400_grad0_opsz24)
            val img3 = painterResource(id = R.drawable.mail_fill0_wght400_grad0_opsz24)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(7.dp)
            ) {
                Image(painter = img1, contentDescription = null, modifier = modifier.width(30.dp).height(30.dp))
                Text(text = stringResource(id = R.string.mobile))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(7.dp)
            ) {
                Image(painter = img2, contentDescription = null, modifier = modifier.width(30.dp).height(30.dp))
                Text(text = stringResource(id = R.string.social))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(7.dp)
            ) {
                Image(painter = img3, contentDescription = null, modifier = modifier.width(30.dp).height(30.dp))
                Text(text = stringResource(id = R.string.email))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessTheme {
        Greeting()
    }
}