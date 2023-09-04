package com.karnamic.wealthpix.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.karnamic.wealthpix.ui.custom_views.PieChart
import com.karnamic.wealthpix.ui.custom_views.PieChartInput
import com.karnamic.wealthpix.ui.navigation.Screen
import com.karnamic.wealthpix.ui.theme.WealthPixTheme
import com.karnamic.wealthpix.ui.theme.*


@Preview
@Composable
fun HomeScreen() {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Investments",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = darkBlue,
            textAlign = TextAlign.Center,
        )
        PieChart(
            modifier = Modifier
                .size(300.dp)
                .padding(top = 24.dp),
            radius = 300f,
            centerText = "show",
            input = listOf(
                PieChartInput(
                    color = brightBlue,
                    value = 29,
                    description = "Python"
                ),
                PieChartInput(
                    color = purple,
                    value = 21,
                    description = "Swift"
                ),
                PieChartInput(
                    color = blueGray,
                    value = 32,
                    description = "JavaScript"
                ),
                PieChartInput(
                    color = redOrange,
                    value = 18,
                    description = "Java"
                ),
                PieChartInput(
                    color = green,
                    value = 12,
                    description = "Ruby"
                ),
                PieChartInput(
                    color = orange,
                    value = 38,
                    description = "Kotlin"
                ),
            )
        )
    }
}

