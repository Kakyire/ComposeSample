package com.kakyiretechnologies.composesample.ui.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * @author Kakyire
 * Created by Daniel Frimpong on December 06, 2023.
 * https://github.com/kakyire
 */


@Composable
fun PinTextField(
    modifier: Modifier = Modifier,
    inputSize: Int = 4,
    fontSize: TextUnit = 16.sp,
    onChange: (String) -> Unit
) {

    val focusManager = LocalFocusManager.current

    var pinValue by remember {
        mutableStateOf("")
    }
    if (inputSize < 4 || inputSize > 6) {
        throw IllegalArgumentException("Input size should be between 4 to 6")
    }


    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        value = pinValue,
        onValueChange = {
            if (it.length <= inputSize) {
                pinValue = it
                onChange(it)
            }
            if (it.length == inputSize) {
                focusManager.clearFocus()
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
//                modifier = Modifier,

                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(inputSize) { index ->
                    val char = when {
                        index < pinValue.length -> pinValue[index].toString()
                        else -> ""
                    }

                    val isFocus = index == pinValue.length

                    val borderSize = if (isFocus) 2.dp else 1.dp
                    val borderColor = if (isFocus) Color.DarkGray else Color.LightGray
                    Text(
                        text = char,
                        Modifier
                            .size(50.dp)
                            .border(
                                borderSize,
                                borderColor,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = fontSize
                        )

                    )
                    Spacer(modifier = modifier.width(10.dp))
                }

            }
        }

    )


}


@Preview(showBackground = true)
@Composable
fun PinTextFieldPreview() {
    PinTextField {}
}