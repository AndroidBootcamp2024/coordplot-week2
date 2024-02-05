package com.kodeco.android.coordplot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.theme.CoordPlotTheme

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(300.dp)
            .background(MaterialTheme.colorScheme.secondary),
    ) {
        Image(
            painter = painterResource(id = R.drawable.mini_car),
            contentDescription = "Star pin",
            modifier = Modifier
                .size(36.dp)
                .offset((xPercent * 264).dp, (yPercent * 264).dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    CoordPlotTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
