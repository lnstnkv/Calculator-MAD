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
import androidx.compose.ui.graphics.Color
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
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        val sequenceSymbols = CalcSymbols.values().toList().chunked(4)
        sequenceSymbols.forEach { row ->
            Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(), Arrangement.SpaceBetween
            ) {
                row.forEachIndexed { index, symbol ->

                    CalcButton(
                        s = symbol,
                        background = if (index == 3) Blue else WhiteDefault,
                        textColor = if (index == 3) Color.White else Blue,
                        modifier =
                            Modifier
                                .width(80.dp)
                                .height(80.dp)

                    )

                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }

}

@Composable
fun CalcButton(
    s: CalcSymbols,
    background: Color,
    textColor: Color,
    modifier: Modifier
) {
    Button(
        onClick = {

        },
        shape = RoundedCornerShape(25),
        elevation = null,
        colors = buttonColors(backgroundColor = background),
        modifier = modifier
    ) {
        Text(text = s.displayValue, style = TextButtonStyle, color = textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MADCalculatorTheme {
        Input()
    }
}