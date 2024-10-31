package com.example.loteria.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loteria.viewModels.LoteriaViewModels
import androidx.compose.foundation.lazy.items

@Composable
fun LoteriaView(viewModels: LoteriaViewModels) {
    val lottoNumbers = viewModels.lotoNumbers.value
    val isGenerating = viewModels.isGenerating.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (lottoNumbers.isEmpty() && !isGenerating) {
            Text(text = "Loteria", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        } else {
            LotteryNumbers(lottoNumbers)
        }

        if (isGenerating) {
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        }

        Button(onClick = { viewModels.generateLotoNumbers() }, enabled = !isGenerating) {
            Text(text = "Generar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LotteryNumbers(lottoNumbers: List<Int>) {
    LazyRow(
        modifier = Modifier.padding(vertical = 16.dp),
    ) {
        items(lottoNumbers) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Magenta, CircleShape)
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}
