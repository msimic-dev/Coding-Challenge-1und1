package com.msimic.codingchallenge1und1.ui.addresses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme
import java.util.jar.Attributes.Name

@Composable
fun SalesmanItem(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean = false,
    onClick: () -> Unit = {},
) {

}

@Composable
fun NameFirstLetterIndicator(
    letter: Char,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray, CircleShape)
            .size(42.dp)
            .clip(CircleShape)
    ) {
        Text(
            text = letter.toString(),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 32.sp,
        )
    }
}

@Preview
@Composable
fun SalesmanItemPreview() {
    CodingChallenge1und1Theme {
        SalesmanItem()
    }
}