package com.kakyiretechnologies.composesample.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kakyiretechnologies.composesample.R
import com.kakyiretechnologies.composesample.ui.components.InitialsIcon
import com.kakyiretechnologies.composesample.ui.components.PinTextField
import com.kakyiretechnologies.composesample.ui.theme.DarkGreen
import com.kakyiretechnologies.composesample.ui.theme.Green
import com.kakyiretechnologies.composesample.ui.theme.LightGreen
import com.kakyiretechnologies.composesample.ui.theme.Orange


/**
 * @author Kakyire
 * Created by Daniel Frimpong on December 07, 2023.
 * https://github.com/kakyire
 */

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {

    var pinValue by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        LightGreen,
                        DarkGreen
                    )
                )
            )
    ) {
        Image(
            modifier = modifier
                .align(Alignment.TopStart)
                .padding(16.dp),
            painter = painterResource(id = R.drawable.back_filled_white),
            contentDescription = "back"
        )

        Box(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(16.dp)
        ) {


            Column(
                modifier = modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Spacer(modifier = modifier.padding(top = 50.dp))
                Text(
                    text = "Welcome back",
                    modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(fontSize = 26.sp)
                )
                Text(
                    text = "UserName", modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight(700))
                )
                Text(text = "ENTER PIN")
                PinTextField(
                    onChange = { pinValue = it })
                TextButton(onClick = {

                }) {
                    Text(
                        text = "Forget PIN?",
                        style = TextStyle(color = Orange, textDecoration = TextDecoration.Underline)
                    )
                }

                Button(modifier = modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Green),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Sign In")
                }

            }

            Box(
//                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .align(Alignment.TopCenter)
                    .offset(y = (-30).dp)

            ) {
                InitialsIcon(
                    text = "Daniel", strokeSize = 3.dp, size = 120f, modifier = modifier.align(
                        Alignment.Center
                    )
                )
                Image(
                    modifier = modifier
                        .offset(x = (30).dp, y = (10).dp)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.ic_spark),
                    contentDescription = ""
                )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SigInScreenPreview() {
    SignInScreen()
}