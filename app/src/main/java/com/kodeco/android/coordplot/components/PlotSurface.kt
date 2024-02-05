package com.kodeco.android.coordplot.components

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.theme.CoordPlotTheme
import kotlinx.coroutines.delay

@Composable
fun PlotSurface() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        var showSplashScreen by remember { mutableStateOf(true) }

        LaunchedEffect(true) {
            delay(5000) // 5 seconds delay
            showSplashScreen = false
        }

        if (showSplashScreen) {
            SplashScreen()
        } else {
            ContentPlotSurface()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ContentPlotSurfacePreview() {
    CoordPlotTheme {
        ContentPlotSurface()
    }
}

@Composable
fun ContentPlotSurface() {
    var xPercentage: Float by remember { mutableStateOf(0.5f) }
    var yPercentage: Float by remember { mutableStateOf(0.5f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Map(xPercentage, yPercentage)
        MapSlider(titleRes = R.string.x_coord_title,
            percentage = xPercentage,
            onPercentageChange = {
                xPercentage = it
            })
        MapSlider(titleRes = R.string.y_coord_title,
            percentage = yPercentage,
            onPercentageChange = {
                yPercentage = it
            })
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        Text (
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.title),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f),
            contentScale = ContentScale.Fit
        )
        Text (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.by_julio),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    CoordPlotTheme {
        SplashScreen()
    }
}