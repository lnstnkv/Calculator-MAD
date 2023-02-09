package com.example.mad_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad_calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADCalculatorTheme {
                NameApp()
                TableButtons()
            }
        }
    }
}

@Composable
fun NameApp() {
    Text(text = "Calculator",style = TextNameStyle)
}

@Composable
fun TableButtons() {
    Spacer(modifier = Modifier.height(16.dp))
    Column() {
        for (j in 0..4) {
            RowButton()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun RowButton() {
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(), Arrangement.SpaceBetween
    ) {
        for (i in 0..3) {
            if (i == 3) {
                MathOperationSignsButton()
            }
            WhiteButton()
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}


@Composable
fun WhiteButton() {
    Button(
        onClick = {

        },
        shape = RoundedCornerShape(25),
        elevation = null,
        colors = buttonColors(backgroundColor = WhiteDefault),
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
    ) {
        Text(text = "0", style = TextWhiteButtonStyle)
    }
}

@Composable
fun MathOperationSignsButton() {
    Button(
        onClick = {

        },
        shape = RoundedCornerShape(25),
        elevation = null,
        colors = buttonColors(backgroundColor = Blue),
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
    ) {
        Text(text = "+", style = TexBlueButtonStyle)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MADCalculatorTheme {
        TableButtons()
    }
}