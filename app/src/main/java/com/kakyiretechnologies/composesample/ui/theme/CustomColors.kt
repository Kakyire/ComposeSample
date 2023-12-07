package com.kakyiretechnologies.composesample.ui.theme

import androidx.compose.ui.graphics.Color


/**
 * @author Kakyire
 * Created by Daniel Frimpong on December 07, 2023.
 * https://github.com/kakyire
 */

object CustomColors {


    val randomColor: Color
        get() {
            val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)

            return Color(color = color)
        }
}