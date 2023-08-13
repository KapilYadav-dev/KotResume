package `in`.mrkaydev.portfolio.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp

object Utils {
    @Composable
    fun Int.toDp() = Dp(this@toDp.toFloat())

    @Composable
    fun Int.toSp() = with(LocalDensity.current) { Dp(this@toSp.toFloat()).toSp() }

    fun getColorElseBlack(colorName: String?): Color {
        return when (colorName?.lowercase()) {
            "black" -> Color.Black
            "white" -> Color.White
            "red" -> Color.Red
            "green" -> Color.Green
            "blue" -> Color.Blue
            "yellow" -> Color.Yellow
            "cyan" -> Color.Cyan
            "magenta" -> Color.Magenta
            "gray", "grey" -> Color.Gray
            "lightGray", "lightGray".lowercase(), "lightGrey", "lightGrey".lowercase() -> Color.LightGray
            "darkGray", "darkGray".lowercase(), "darkGrey", "darkGrey".lowercase() -> Color.DarkGray
            "transparent" -> Color.Transparent
            else -> Color.Black
        }
    }
    fun getFontWeightElseNormal(fontWeight: String?) : FontWeight {
        return when(fontWeight) {
            "light","thin"-> return FontWeight.Light
            "normal","regular"-> return FontWeight.Normal
            "medium"-> return FontWeight.Medium
            "bold"-> return FontWeight.Bold
            "semiBold"-> return FontWeight.SemiBold
            else -> FontWeight.Normal
        }
    }
}