package `in`.mrkaydev.portfolio.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

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

    fun getFontStyleElseNormal(fontStyle:String?): FontStyle {
        return when(fontStyle) {
            "italic","italics"-> return FontStyle.Italic
            "normal"-> return FontStyle.Normal
            else -> FontStyle.Normal
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun Toast(message: String) {
        Popup {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Surface(
                    modifier = Modifier.padding(16.dp),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Black.copy(alpha = 0.8f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(2.dp))
                        Image(painter = painterResource("icon.png"), modifier = Modifier.size(24.dp).padding(2.dp), contentDescription = "")
                        Text(
                            text = message,
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                            style = TextStyle(fontFamily = FontLoader.Montserrat, fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}