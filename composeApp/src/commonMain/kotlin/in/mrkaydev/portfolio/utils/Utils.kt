package `in`.mrkaydev.portfolio.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import kotlin.math.min

object Utils {

    const val RESUME_JSON_URL = "https://api.npoint.io/5b610d92313fc4db805c"
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

    fun getFontStyleElseNormal(fontStyle:String?): FontStyle {
        return when(fontStyle) {
            "italic","italics"-> return FontStyle.Italic
            "normal"-> return FontStyle.Normal
            else -> FontStyle.Normal
        }
    }
}