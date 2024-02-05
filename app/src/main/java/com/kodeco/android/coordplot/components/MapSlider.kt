package com.kodeco.android.coordplot.components

import android.text.Layout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Slider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.theme.CoordPlotTheme

@Composable
fun MapSlider(titleRes: Int, percentage: Float, onPercentageChange: (Float) -> Unit) {
    val textString = stringResource(id = titleRes)
    Row(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        Text(
            text ="$textString : ${String.format("%.2f",percentage * 100)} %",
            modifier = Modifier.width(120.dp)
                .padding(8.dp, 16.dp, 0.dp, 0.dp)
        )
        Slider(
            value = percentage,
            onValueChange = onPercentageChange)
    }
}

@Preview(showBackground = true)
@Composable
fun MapSliderPreview() {
    CoordPlotTheme {
        MapSlider(
            titleRes = R.string.app_name,
            percentage = 0.5f,
        ) {}
    }
}
