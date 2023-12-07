package com.kakyiretechnologies.composesample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kakyiretechnologies.composesample.extensions.firstLetter
import com.kakyiretechnologies.composesample.extensions.initials
import com.kakyiretechnologies.composesample.ui.theme.DarkGreen
import com.kakyiretechnologies.composesample.ui.theme.Orange


/**
 * @author Kakyire
 * Created by Daniel Frimpong on December 07, 2023.
 * https://github.com/kakyire
 */


private const val COLOR_ALPHA = 0.3f

private val Modifier.BOX_SHADOW: Modifier
    get() = this.shadow(
        0.5.dp,
        shape = CircleShape,
        ambientColor = Color.Blue,
        spotColor = Color.DarkGray
    )

@Composable
fun InitialsIcon(
    text: String,
    modifier: Modifier = Modifier,
    size: Float = 100f,
    strokeSize: Dp = 0.dp,
    strokeColor: Color = DarkGreen,
    textColor: Color = Color.White,
    backgroundColor: Color = Orange,
    firstLettersOnly: Boolean = true
) {

    val density = LocalDensity.current
    val iconSize = with(density) { (size * 2).toDp() }
    val textSize = (size / 2).sp

    val mText = if (firstLettersOnly) {
        text.firstLetter
    } else {
        text.initials
    }

    Box(
        modifier = modifier

            .size(iconSize)
            .clip(shape = CircleShape)
            .BOX_SHADOW
            .background(backgroundColor)
            .border(width = strokeSize, color = strokeColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = mText, style = TextStyle(
                fontSize = textSize,
                color = textColor,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.Center)
        )
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun InitialsIconPreview() {
    InitialsIcon(
        text = "Daniel Frimpong",
        size = 100f,
        strokeSize = 3.dp,
        modifier = Modifier.padding(20.dp)
    )
}