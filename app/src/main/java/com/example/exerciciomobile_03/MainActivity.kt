package com.example.exerciciomobile_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciciomobile_03.ui.theme.ExercicioMobile03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioMobile03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComponetesScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComponetesScreen(modifier: Modifier = Modifier) {

    var idade by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Qual é a sua idade?",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF426FEA),
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "$idade",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF426FEA),
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (idade > 0){
                        idade--
                    }
                },

                modifier = Modifier.size(60.dp),
                border = BorderStroke(2.dp, color = Color.Black),
                shape = RoundedCornerShape(
                    6.dp,
                    6.dp,
                    6.dp,
                    6.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF426FEA)
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {
                    if (idade < 180) {
                        idade++
                    }
                },
                modifier = Modifier.size(60.dp),
                border = BorderStroke(2.dp, color = Color.Black),
                shape = RoundedCornerShape(
                    6.dp,
                    6.dp,
                    6.dp,
                    6.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF426FEA)
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp
                )
            }
        }

        Text(
            text = if (idade >= 18){
                "Você é Maior de idade"
            }else{
                "Você é Menor de idade"
                 },
            color = Color(0xFF426FEA),
            fontSize = 25.sp,
            fontWeight = FontWeight.W100,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

    }


}

