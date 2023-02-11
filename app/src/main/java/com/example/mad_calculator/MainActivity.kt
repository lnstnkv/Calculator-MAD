package com.example.mad_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad_calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADCalculatorTheme {
                Column(Modifier.padding(8.dp)) {
                    NameApp()
                    Input()
                    TableButtons()
                }
            }
        }
    }
}

@Composable
fun Input() {
    val gradient = Brush.verticalGradient(colors = listOf(BlackGreen, LightGreen))
    Box(
        modifier = Modifier
            .size(366.dp, 100.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp),
                true,
                BorderInput,
                BorderInput
            )
            .clip(RoundedCornerShape(10.dp))
            .background(gradient)
    ) {
        Text(text = "8888888888", style = TextInputStyle)
    }
}

@Composable
fun NameApp() {
    Text(text = "Calculator", style = TextNameStyle)
}

@Composable
fun TableButtons() {
    Spacer(modifier = Modifier.height(16.dp))
    val namesButtons = listOf(
        listOf("AC", "+/-", "%", "÷"),
        listOf("7", "8", "9", "X"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0","0", ",", "=")
    )
    Column() {
        for (row in namesButtons) {
            RowButton(row)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun RowButton(namesButtons: List<String>) {
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(), Arrangement.SpaceBetween
    ) {
        for (i in 0..3) {
            if (i == 3) {
                MathOperationSignsButton(namesButtons[i])
            }
            WhiteButton(namesButtons[i])
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}


@Composable
fun WhiteButton(s: String) {
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
        Text(text = s, style = TextWhiteButtonStyle)
    }
}

@Composable
fun MathOperationSignsButton(s: String) {
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
        Text(text = s, style = TexBlueButtonStyle)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MADCalculatorTheme {
        Input()
    }
}